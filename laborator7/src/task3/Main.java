package task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            String fileName = "fisier_" + i + ".txt";
            writeToFile(fileName, i);
        }
    }

    private static void writeToFile(String fileName, int index) {
        File file = new File("src/task3/" + fileName);
        try (FileWriter fileWriter = new FileWriter(file)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);
            fileWriter.write("Index: " + index + "\n");
            fileWriter.write("Data si ora: " + formattedDateTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
