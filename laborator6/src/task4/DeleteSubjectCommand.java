package task4;

public class DeleteSubjectCommand implements Command {
    private Database database;
    private String name;

    public DeleteSubjectCommand(Database database, String name) {
        this.database = database;
        this.name = name;
    }

    @Override
    public void execute() {
        database.deleteSubject(name);
    }
}
