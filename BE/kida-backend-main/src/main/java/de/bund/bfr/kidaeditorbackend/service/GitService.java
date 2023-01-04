package de.bund.bfr.kidaeditorbackend.service;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;

/**
 * Service class that implements methods that allow interaction with git operations for
 * persisting and reading to/from Git
 */
@Component
@Slf4j
public class GitService {

    @Value("${git-access-token}")
    private String token;

    @Value("${schema-git-clone-directory}")
    private String localGitDirectory;

    /**
     * Pulls a git repository to the local files (if not existent clones it first)
     *
     * @param gitRepo           The git repo to clone.
     */
    public String pullOrCloneRepository(String gitRepo) throws GitAPIException, IOException {
        String repoFolder = localGitDirectory + gitRepo.replaceAll("[\\\\/:*?\"<>|]", "");

        File dotGitDirectory = new File(repoFolder + "\\.git");

        if (!dotGitDirectory.exists()) {
            cloneRepository(gitRepo, repoFolder);
            return repoFolder;
        }

        try (Git git = Git.open(new File(repoFolder))) {
            git.pull()
                    .call();
        }
        return repoFolder;
    }


    /**
     * Creates a commit for the selected files and the pushes the commit to the remote
     *
     * @param folderName        Local git directory
     * @param filesToCommit     Collection of files that are supposed to be committed and pushed
     * @param accessToken       accessToken for authentication to git (falls back to application properties if not
     *                          supplied)
     */
    public void executeAddCommitPushFiles(String folderName, Collection<File> filesToCommit, String accessToken)
            throws IOException, GitAPIException {

        try (Git git = Git.open(new File(folderName))) {
            for (File currentFile : filesToCommit) {
                git.add()
                        .addFilepattern(currentFile.getName())
                        .call();
            }

            // Commit
            String commitMessage = "Updating: " + StringUtils.arrayToDelimitedString(filesToCommit.toArray(), ",");
            git.commit()
                    .setMessage(commitMessage)
                    .call();
            log.info("Committed: [Editor] " + commitMessage);

            // Push
            git.push()
                    .setCredentialsProvider(getCredentialsProvider(accessToken))
                    .call();
        }
    }

    /**
     * Clones a git repository to the local files
     *
     * @param gitRepo         The git repo to clone.
     * @param schemaDirectory An directory on the local file system where the git repo will be cloned to.
     *                        Use a dedicated directory for this, because all files in it will be deleted in the process
     *                        because the clone requires an empty directory.
     */
    private void cloneRepository(String gitRepo, String schemaDirectory) throws GitAPIException, IOException {
        File directory = new File(schemaDirectory);
        //Git clone requires an empty directory
        deleteDirectory(directory);

        Git git = Git.cloneRepository()
                .setURI(gitRepo)
                .setDirectory(directory)
                .call();

        git.close();
    }
    private void deleteDirectory(File directoryToBeDeleted) throws IOException {
        if (!directoryToBeDeleted.exists())
            return;
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        Files.delete(directoryToBeDeleted.toPath());
    }


    private CredentialsProvider getCredentialsProvider(String accessToken) {
        if (accessToken == null) {
            accessToken = this.token;
        }
        return new UsernamePasswordCredentialsProvider(accessToken, "");
    }
}
