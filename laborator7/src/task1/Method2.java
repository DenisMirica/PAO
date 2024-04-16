package task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Method2 {
    public static void main(String[] args) {
        readAndPrintWithoutFirstLine("C:\\Users\\remus\\IdeaProjects\\laborator7\\src\\task1\\file.txt");
    }
    private static void readAndPrintWithoutFirstLine(String filePath) {
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file)) {
            boolean skipLine = true;
            int character;
            while ((character = fis.read()) != -1) {
                if (skipLine && (char) character == '\n') {
                    skipLine = false;
                    continue;
                }
                if (!skipLine) {
                    System.out.print((char) character);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
