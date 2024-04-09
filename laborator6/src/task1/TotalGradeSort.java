package task1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TotalGradeSort implements SortStrategy {
    @Override
    public void sort(List<Student> students) {
        Collections.sort(students, Comparator.comparingDouble(Student::getTotalGrade).reversed());
    }
}
