package lab1.task2;
import java.util.Random;
public class Course {
    String name;
    double minimumGrade;
    Student[] students;

    public String getName(){

        return name;
    }

    public void setName(String name_){

        this.name = name_;
    }
    public double getMinimumGrade(){

        return minimumGrade;
    }

    public void setMinimumGrade(double minimumGrade_){

        this.minimumGrade = minimumGrade_;
    }

    public Student chooseStudentRandomly(){
        Random random = new Random();
        int randomIndex = random.nextInt(students.length);
        return students[randomIndex];
    }

    public Student[] showAllPassingStudents() {
        Student[] nrStudents = new Student[students.length];
        int index = 0;
        for (Student student : students) {
            if (student.grade >= minimumGrade) {
                nrStudents[index] = student;
                index++;
            }
        }
        return nrStudents;
    }

    public boolean isStudentPassing(int studentIndex) {
        if (studentIndex >= 0 && studentIndex < students.length) {
            return students[studentIndex].grade >= minimumGrade;
        }
        return false;
    }

    public boolean isStudentPassing(Student student) {
        for (Student s : students) {
            if (s.equals(student)) {
                return s.grade >= minimumGrade;
            }
        }
        return false;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}