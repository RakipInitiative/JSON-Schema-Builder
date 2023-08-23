package de.bund.bfr.kidaeditorbackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.bund.bfr.kidaeditorbackend.dto.SchemaMetaDataResponseDto;
import de.bund.bfr.kidaeditorbackend.util.ZipHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Service class that implements the use cases for doing the desired create, read, update operations for
 * model schemas.
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class ModelService {

    private final OpenApiService openApiService;

    private static final String LOOKUP_FILE_NAME = "schemaLookup.json";

    @Value("${schema-git-remote-repository}")
    private String remoteRepoCloneUrl;

    @Value("${openapi-class-generation-directory}")
    private String openapiClassGenerationDirectory;

    @Value("${openapi-jar-path}")
    private String openapiJarPath;

    private final GitService gitService;

    /**
     * Accesses the Git repo, clones it to the local files and returns the meta data (id, name, url) for all schema models.
     *
     * @return metadata for all managed schemas (id, name, url)
     */
    public Collection<SchemaMetaDataResponseDto> getAllModels() throws GitAPIException, IOException {

        gitService.pullOrCloneRepository(remoteRepoCloneUrl);

        return getStringSchemaMetaDataMap().values();
    }

    /**
     * Gets a schema from the local git specified by the id provided.
     *
     * @param id id of the desired schema
     * @return schema as a String
     */
    public String getModel(String id) throws IOException, GitAPIException {
        Pair<String, String> schemaFileData = findSchemaFileById(id);
        String folderName = gitService.pullOrCloneRepository(schemaFileData.getLeft());
        File schemaFile = new File(folderName + File.separator + schemaFileData.getRight());
        return Files.readString(Path.of(schemaFile.getAbsolutePath()));
    }


    /**
     * Saves the updated model schema by overwriting the existing file.
     * This will cause a commit and push to the remote
     *
     * @param id            id of the schema to save
     * @param updatedSchema the new updated schema
     * @param accessToken   accessToken for authentication to git (falls back to application properties if not supplied)
     */
    public void saveModel(String id, String updatedSchema, String accessToken) throws IOException, GitAPIException {
        Pair<String, String> schemaFileData = findSchemaFileById(id);

        String folderName = gitService.pullOrCloneRepository(schemaFileData.getLeft());
        File schemaFile = new File(folderName + File.separator + schemaFileData.getRight());

        String decodedSchema = new String(Base64.getDecoder().decode(updatedSchema));
        Files.writeString(Path.of(schemaFile.getAbsolutePath()), decodedSchema);

        gitService.executeAddCommitPushFiles(folderName, List.of(schemaFile), accessToken);
    }

    private Pair<String, String> findSchemaFileById(String id) throws IOException, GitAPIException {
        Map<String, SchemaMetaDataResponseDto> schemaMetaData = getStringSchemaMetaDataMap();

        return Pair.of(schemaMetaData.get(id).getUrl(), schemaMetaData.get(id).getFileName());
    }

    public InputStreamResource download(String id) throws GitAPIException, IOException {

        String openApiSpec = getOpenApicSpec(id);

        InputStream inputStream = new ByteArrayInputStream(openApiSpec.getBytes(StandardCharsets.UTF_8));
        return new InputStreamResource(inputStream);
    }

    public String getOpenApicSpec(String id) throws GitAPIException, IOException {
        Pair<String, String> schemaFileData = findSchemaFileById(id);

        String folderName = gitService.pullOrCloneRepository(schemaFileData.getLeft());
        File schemaFile = new File(folderName + File.separator + schemaFileData.getRight());

        JSONObject schema = new JSONObject(Files.readString(Path.of(schemaFile.getAbsolutePath())));

        return openApiService.getOpenApiSpecFromJson(schema);
    }

    public Pair<String, InputStreamResource> generateClasses(String id, String language) throws GitAPIException, IOException {
        String openApiSpec = this.getOpenApicSpec(id);
        File generationFolder = new File(openapiClassGenerationDirectory);
        if (!generationFolder.exists()) {
            generationFolder.mkdir();
        }

        Path specPath = Path.of(generationFolder.getPath() + "/openApiSpec.json");
        Files.writeString(specPath, openApiSpec);

        File generatedClassesFolder = new File(generationFolder.getPath() + "/generatedModelClasses");

        // set output language to java as default
        if (language == null) {
            language = "java";
        }

        generateClasses(specPath, generatedClassesFolder, language);
        File zipFile = ZipHelper.zipDirectory(generatedClassesFolder);
        cleanupGeneratedFiles(new File(specPath.toString()), generatedClassesFolder);
        return Pair.of(zipFile.getName(), new InputStreamResource(new FileInputStream(zipFile)));
    }

    private void generateClasses(Path specPath, File generatedClassesFolder, String language) throws IOException {

        log.info("OpenApiGenerator-Jar exists?: " + new File(openapiJarPath).exists());
        log.info("OpenApi-Spec file exists?: " + new File(specPath.toString()).exists());

        if (!generatedClassesFolder.exists()) {
            generatedClassesFolder.mkdir();
        }

        // If on Windows specPath and generatedFolder path need to be wrapped in quotes if the path
        // contains a space.
        // On linux (AWS) the quotes break the path.
        String command = "generate -i " + specPath.toAbsolutePath()
                + " -l " + language
                + " -o " + generatedClassesFolder.getAbsolutePath()
                + " --model-package de.bund.bfr.metadata.swagger --use-oas2";

        String executedCommand = "java -jar " + openapiJarPath + StringUtils.SPACE + command;

        Process proc = null;
        try {
            proc = Runtime.getRuntime().exec(executedCommand);

            // Wait for generation to finish
            while (proc.isAlive()) {
                String inputLine = null;
                if (proc.getInputStream().available() > 0) {
                    inputLine = proc.inputReader().readLine();
                    log.info(inputLine);
                }
                if (proc.getErrorStream().available() > 0) {
                    String errorLine = proc.errorReader().readLine();
                    log.error(errorLine);
                }
            }
            log.info("Class Generation finished");
        } finally {
            if (proc != null && proc.isAlive()) {
                proc.destroy();
            }
        }
    }

    private void cleanupGeneratedFiles(File specFile, File classesDirectory) throws IOException {
        specFile.delete();
        FileUtils.deleteDirectory(classesDirectory);
    }

    private Map<String, SchemaMetaDataResponseDto> getStringSchemaMetaDataMap() throws IOException, GitAPIException {
        String repoFolder = gitService.pullOrCloneRepository(remoteRepoCloneUrl);
        return getStringSchemaMetaDataMap(repoFolder);
    }

    private Map<String, SchemaMetaDataResponseDto> getStringSchemaMetaDataMap(String repoFolder) throws IOException, GitAPIException {
        File lookupFile = getLookupFile(repoFolder);
        return new ObjectMapper().readValue(lookupFile, new TypeReference<>() {
        });
    }


    private File getLookupFile(String repoFolder) throws IOException, GitAPIException {
        if (repoFolder == null) {
            repoFolder = gitService.pullOrCloneRepository(remoteRepoCloneUrl);
        }
        File lookupFile = new File(repoFolder + File.separator + LOOKUP_FILE_NAME);

        if (!lookupFile.exists()) {
            throw new IOException("Lookup file not found in git repository");
        }

        return lookupFile;
    }


    public void addModel(String url, String fileName, String name, String accessToken) throws GitAPIException, IOException {
        // Check out the new repository
        String newRepoFolder = gitService.pullOrCloneRepository(url);
        // Read file to get id
        File newfile = new File(newRepoFolder + File.separator + fileName);
        String schema = Files.readString(Path.of(newfile.getAbsolutePath()));
        JSONObject jsonObject = new JSONObject(schema);
        String id = jsonObject.getString("$id");

        // Save into our structure
        SchemaMetaDataResponseDto newModel = SchemaMetaDataResponseDto.builder()
                .url(url)
                .fileName(fileName)
                .name(name)
                .id(id)
                .build();

        // Fetch metadata file with all handled json schemas
        String repoFolder = gitService.pullOrCloneRepository(remoteRepoCloneUrl);
        Map<String, SchemaMetaDataResponseDto> oldModels = getStringSchemaMetaDataMap(repoFolder);
        // Add new json schemas
        oldModels.put(id, newModel);

        // Write back metadata file
        ObjectMapper objectMapper = new ObjectMapper();
        File lookupFile = new File(repoFolder + File.separator + LOOKUP_FILE_NAME);
        Files.writeString(Path.of(lookupFile.getAbsolutePath()),
                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(oldModels));

        // Commit it
        gitService.executeAddCommitPushFiles(repoFolder, List.of(lookupFile), accessToken);
    }
}
