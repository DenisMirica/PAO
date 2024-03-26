package task3;
import java.util.HashMap;
import java.util.Map;

public class Student implements Cloneable {
    private String fullName;
    private Map<String, Double> courseInformation;

    public Student(String fullName, Map<String, Double> courseInformation) {
        this.fullName = fullName;
        this.courseInformation = courseInformation;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student clonedStudent = (Student) super.clone();
        clonedStudent.courseInformation = new HashMap<>(this.courseInformation);
        return clonedStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", courseInformation=" + courseInformation +
                '}';
    }
}
