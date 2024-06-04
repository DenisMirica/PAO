package task6;

import task6.CharacterCounter;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java task6.Main <file-path> <character>");
            return;
        }

        String filePath = args[0];
        char characterToCount = args[1].charAt(0);

        CharacterCounter counter = new CharacterCounter(filePath, characterToCount);
        counter.countOccurrences();
    }
}
