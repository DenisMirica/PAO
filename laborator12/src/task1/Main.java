package task1;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        MyUtilityClass.printCollection(integers);

        List<String> strings = List.of("ana", "are", "mere");
        MyUtilityClass.printCollection(strings);

        List<Boolean> booleans = List.of(true, false, true, false, true);
        {
            boolean result = MyUtilityClass.aggregate(booleans, true, (acc, v) -> acc & v);
            System.out.println(result);
        }
        {
            int result = MyUtilityClass.aggregate(booleans, 0, (acc, v) -> v ? acc + 1 : acc);
            System.out.println(result);
        }

        record Person(String name) {}

        List<Person> persons = List.of(
                new Person("Aurel"),
                new Person("Vali")
        );

        List<Person> duplicatedPersons = MyUtilityClass.duplicateCollection(persons);
        MyUtilityClass.printCollection(duplicatedPersons);
    }
}
