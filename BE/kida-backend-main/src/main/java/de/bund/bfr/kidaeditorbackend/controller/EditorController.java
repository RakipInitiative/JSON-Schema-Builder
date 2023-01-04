package de.bund.bfr.kidaeditorbackend.controller;

import de.bund.bfr.kidaeditorbackend.dto.AddSchemaDto;
import de.bund.bfr.kidaeditorbackend.dto.SchemaIdDto;
import de.bund.bfr.kidaeditorbackend.dto.SchemaMetaDataResponseDto;
import de.bund.bfr.kidaeditorbackend.dto.SchemaUpdateDto;
import de.bund.bfr.kidaeditorbackend.service.ModelService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping("/kidaBackend")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EditorController {

    private final ModelService modelService;

    /**
     * Lists all the available models and their metadata
     *
     * @return Collection of schema metadata
     */
    @Operation(summary = "Lists all the available models and their metadata",
            description = "Accesses the Git repo and lists all the available models and their meta data (id, name, "
                    + "url)")
    @GetMapping(value = "/allModels", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<SchemaMetaDataResponseDto>> getAllModels() {

        try {
            return ResponseEntity.ok()
                    .body(modelService.getAllModels());
        } catch (GitAPIException | IOException e) {
            log.error("Error while retrieving model list.", e);
            return ResponseEntity.internalServerError()
                    .build();
        }
    }

    /**
     * Returns the schema specified by the id. This is a post mapping because the id contains slash-characters
     *
     * @param idDto The id of the schema
     * @return The schema in the local files that was specified by the id
     */
    @Operation(summary = "Get a single model schema.",
            description = "Returns a single model schema specified by the id of the model schema." +
                    "Returns an empty model if id cannot be found")
    @PostMapping(value = "/getModel", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getModel(@RequestBody SchemaIdDto idDto) {
        try {
            return ResponseEntity.ok()
                    .body(modelService.getModel(idDto.getId()));
        } catch (IOException | GitAPIException e) {
            log.error("Error while retrieving schema.", e);
            return ResponseEntity.internalServerError()
                    .build();
        }
    }

    /**
     * Updates a schema and overwrites the files
     * This will cause a commit and push to the remote
     *
     * @param updateDto Contains ID of the Schema to update and the updated schema
     * @return
     */
    @Operation(summary = "Saves an updated model",
            description = "Saves an updated json schema encoded in base64 specified by the ID and pushes it to Git.")
    @PutMapping(value = "/saveModel", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveModel(@RequestBody SchemaUpdateDto updateDto) {
        try {
            modelService.saveModel(updateDto.getId(), updateDto.getUpdatedSchema(), updateDto.getAccessToken());
            return ResponseEntity.noContent()
                    .build();
        } catch (IOException | GitAPIException e) {
            log.error("Error while updating file", e);
            return ResponseEntity.notFound()
                    .build();
        }
    }

    @Operation(summary = "Returns the OpenAPI spec for a schema.",
            description = "Returns the OpenAPI spec that was converted from the Json Schema and " +
                    "returns the resource so it can be downloaded")
    @PostMapping("/download")
    public ResponseEntity<InputStreamResource> downloadOpenApiSpec(@RequestBody SchemaIdDto idDto) {
        try {
            return ResponseEntity.ok().body(modelService.download(idDto.getId()));
        } catch (IOException | GitAPIException e) {
            log.error("Error while generating API Spec ", e);
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @Operation(summary = "Adds a new schema.",
            description = "Adds a new summary to a file with the specified file name from the URL provided.")
    @PostMapping("/addSchema")
    public ResponseEntity<String> addSchema(@RequestBody AddSchemaDto addSchemaDto) {
        try {
            modelService.addModel(addSchemaDto.getUrl(), addSchemaDto.getFileName(),
                    addSchemaDto.getName(), addSchemaDto.getAccessToken());
            return ResponseEntity.noContent()
                    .build();
        } catch (IOException | GitAPIException e) {
            log.error("Error while retrieving new schema.", e);
            return ResponseEntity.internalServerError()
                    .build();
        }
    }
}
