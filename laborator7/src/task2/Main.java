package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        readAndPrintWithoutFirstLine("C:/Users/remus/IdeaProjects/laborator7/src/task2/file.txt");
    }
    private static void readAndPrintWithoutFirstLine(String filePath) {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fileReader)) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
