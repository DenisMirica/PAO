package task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GitInitClone {

    public static void initializeRepository(String directoryPath) throws IOException {
        File gitDir = new File(directoryPath, ".git");

        createGitStructure(gitDir);
        System.out.println("Initialized empty Git repository in " + gitDir.getAbsolutePath());
    }

    private static void createGitStructure(File gitDir) throws IOException {
        if (!gitDir.exists()) {
            if (!gitDir.mkdirs()) {
                throw new IOException("Failed to create directory: " + gitDir.getAbsolutePath());
            }
        }

        File objectsDir = new File(gitDir, "objects");
        File refsDir = new File(gitDir, "refs");
        File headFile = new File(gitDir, "HEAD");

        if (!objectsDir.exists() && !objectsDir.mkdirs()) {
            throw new IOException("Failed to create directory: " + objectsDir.getAbsolutePath());
        }

        if (!refsDir.exists() && !refsDir.mkdirs()) {
            throw new IOException("Failed to create directory: " + refsDir.getAbsolutePath());
        }

        if (!headFile.exists()) {
            try (FileWriter writer = new FileWriter(headFile)) {
                writer.write("ref: refs/heads/main\n");
            }
        }
    }
}
