package task4;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<String, Student> students;
    private Map<String, Subject> subjects;
    private Map<String, Map<String, Grade>> grades;

    public Database() {
        this.students = new HashMap<>();
        this.subjects = new HashMap<>();
        this.grades = new HashMap<>();
    }

    public void addStudent(String name, String dateOfBirth) {
        students.put(name, new Student(name, dateOfBirth));
    }

    public void addSubject(String name) {
        subjects.put(name, new Subject(name));
    }

    public void enrollStudent(String studentName, String subjectName) {
        if (!grades.containsKey(studentName)) {
            grades.put(studentName, new HashMap<>());
        }
        grades.get(studentName).put(subjectName, new Grade(0.0));
    }

    public void modifyGrade(String studentName, String subjectName, double value) {
        if (grades.containsKey(studentName) && grades.get(studentName).containsKey(subjectName)) {
            grades.get(studentName).get(subjectName).setValue(value);
        } else {
            System.out.println("Student or subject not found.");
        }
    }

    public void deleteStudent(String name) {
        students.remove(name);
        grades.remove(name);
    }

    public void deleteSubject(String name) {
        subjects.remove(name);
        for (Map<String, Grade> studentGrades : grades.values()) {
            studentGrades.remove(name);
        }
    }

    public Map<String, Grade> getStudentGrades(String studentName) {
        return grades.get(studentName);
    }

    public void displayStudentSubjects(String studentName) {
        if (grades.containsKey(studentName)) {
            System.out.println("Subjects and grades for student " + studentName + ":");
            Map<String, Grade> studentGrades = grades.get(studentName);
            for (Map.Entry<String, Grade> entry : studentGrades.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().getValue());
            }
        } else {
            System.out.println("Student not found.");
        }
    }
}