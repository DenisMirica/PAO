package task1;

public class Main {
    public static void main(String[] args) {
        StudentList studentList = StudentList.getInstance();

        studentList.addStudent(new Student("Aurel Vlaicu", 5.3, 7.8, 9.0));
        studentList.addStudent(new Student("Liviu Teodorescu", 7.7, 5.2, 9.0));
        studentList.addStudent(new Student("Denis Mirica", 8, 7, 9.5));

        studentList.sortAndPrint("TotalGrade");
        studentList.sortAndPrint("PartialGrade");
        studentList.sortAndPrint("AverageGrade");
    }
}