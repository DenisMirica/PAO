package task3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> courseInformation = new HashMap<>();
        courseInformation.put("Matematica", 9.5);
        courseInformation.put("Informatica", 8.0);

        Student student1 = new Student("John Doe", courseInformation);
        Student student2 = null;
        try {
            student2 = (Student) student1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        if (student2 != null) {
            System.out.println("Studentul original: " + student1);
            System.out.println("Studentul clonat: " + student2);
        }
    }
}

