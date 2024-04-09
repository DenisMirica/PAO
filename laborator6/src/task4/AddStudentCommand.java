package task4;

public class AddStudentCommand implements Command {
    private Database database;
    private String name;
    private String dateOfBirth;

    public AddStudentCommand(Database database, String name, String dateOfBirth) {
        this.database = database;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public void execute() {
        database.addStudent(name, dateOfBirth);
    }
}

