package task4;

public class ModifyGradeCommand implements Command {
    private Database database;
    private String studentName;
    private String subjectName;
    private double value;

    public ModifyGradeCommand(Database database, String studentName, String subjectName, double value) {
        this.database = database;
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.value = value;
    }

    @Override
    public void execute() {
        database.modifyGrade(studentName, subjectName, value);
    }
}

