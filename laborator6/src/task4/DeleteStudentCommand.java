package task4;

public class DeleteStudentCommand implements Command {
    private Database database;
    private String name;

    public DeleteStudentCommand(Database database, String name) {
        this.database = database;
        this.name = name;
    }

    @Override
    public void execute() {
        database.deleteStudent(name);
    }
}

