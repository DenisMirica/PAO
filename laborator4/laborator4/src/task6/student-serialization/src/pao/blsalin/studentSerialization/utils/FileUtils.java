package pao.blsalin.studentSerialization.utils;

import java.io.*;

public final class FileUtils {

    public static OutputStream openFileForWriting(String path) throws IOException {
        try {
            return new FileOutputStream(path, true);
        } catch (FileNotFoundException e) {
            throw new IOException("File not found: " + path);
        }
    }

    public static InputStream openFileForReading(String path) throws FileNotFoundException {
        return null;
    }
}
