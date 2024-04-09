package task4;

public class EnrollStudentCommand implements Command {
    private Database database;
    private String studentName;
    private String subjectName;

    public EnrollStudentCommand(Database database, String studentName, String subjectName) {
        this.database = database;
        this.studentName = studentName;
        this.subjectName = subjectName;
    }

    @Override
    public void execute() {
        database.enrollStudent(studentName, subjectName);
    }
}

