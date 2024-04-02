package task2;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Teacher {

    private final String firstName;
    private final String lastName;
    private final List<String> subjects;
    private final UUID teacherId;

    public Teacher(String firstName, String lastName, List<String> subjects, UUID teacherId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjects = subjects;
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(firstName, teacher.firstName) &&
                Objects.equals(lastName, teacher.lastName) &&
                Objects.equals(subjects, teacher.subjects) &&
                Objects.equals(teacherId, teacher.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, subjects, teacherId);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
