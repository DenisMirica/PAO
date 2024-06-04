package task5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Bilant> bilantList = new ArrayList<>();
        bilantList.add(new Bilant(10, 5));
        bilantList.add(new Bilant(7, 3));
        bilantList.add(new Bilant(8, 6));

        List<Bilant> sortedBilantList = bilantList.stream()
                .sorted()
                .collect(Collectors.toList());

        sortedBilantList.forEach(System.out::println);
    }
}
