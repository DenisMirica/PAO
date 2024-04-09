package task1;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private static StudentList instance;
    private List<Student> students;

    private StudentList() {
        students = new ArrayList<>();
    }

    public static synchronized StudentList getInstance() {
        if (instance == null) {
            instance = new StudentList();
        }
        return instance;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void sortAndPrint(String sortType) {
        SortStrategy sorter = new SorterFactory().createSorter(sortType);
        sorter.sort(students);

        System.out.println("Sortare după " + sortType + ":");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i));
        }
    }
}
