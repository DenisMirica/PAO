package task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CharacterCounter {
    private final String filePath;
    private final char characterToCount;
    private final AtomicInteger totalOccurrences = new AtomicInteger(0);

    public CharacterCounter(String filePath, char characterToCount) {
        this.filePath = filePath;
        this.characterToCount = characterToCount;
    }

    public void countOccurrences() {
        ExecutorService executor = Executors.newCachedThreadPool();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                final String currentLine = line;
                lineNumber++;

                executor.submit(() -> {
                    int lineOccurrences = 0;
                    for (char ch : currentLine.toCharArray()) {
                        if (ch == characterToCount) {
                            lineOccurrences++;
                        }
                    }
                    totalOccurrences.addAndGet(lineOccurrences);
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
            while (!executor.isTerminated()) {
            }
            System.out.println("Total occurrences of '" + characterToCount + "': " + totalOccurrences.get());
        }
    }
}
