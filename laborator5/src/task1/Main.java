package task1;

import java.io.Serializable;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        MyOptional<String> o1 = MyOptional.of(new String("asd"));
        System.out.println(o1.isPresent()); // true
        System.out.println(o1.get()); // "asd"

        MyOptional<List<String>> o2 = MyOptional.of(List.of("1", "2"));
        System.out.println(o2.isPresent()); // true
        System.out.println(o2.get()); // ["1", "2"]

        MyOptional<Serializable> o3 = MyOptional.of(null);
        System.out.println(o3.isPresent()); // false
        try {
            System.out.println(o3.get()); // NoSuchElementException
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        // MyOptional<Integer> o4 = MyOptional.of("3"); // eroare de compilare
    }
}
