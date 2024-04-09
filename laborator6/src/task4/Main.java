package task4;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        database.addStudent("Denis Mirica", "2003-06-20");

        database.addSubject("Math");
        database.enrollStudent("Denis Mirica", "Math");
        database.modifyGrade("Denis Mirica", "Math", 9.5);

        database.addSubject("Physics");
        database.enrollStudent("Denis Mirica", "Physics");
        database.modifyGrade("Denis Mirica", "Physics", 8.0);

        database.displayStudentSubjects("Denis Mirica");
        database.deleteStudent("Denis Mirica");
        database.deleteSubject("Math");
        database.deleteSubject("Physics");
    }
}