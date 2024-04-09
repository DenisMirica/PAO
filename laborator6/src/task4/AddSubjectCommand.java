package task4;

public class AddSubjectCommand implements Command {
    private Database database;
    private String name;

    public AddSubjectCommand(Database database, String name) {
        this.database = database;
        this.name = name;
    }

    @Override
    public void execute() {
        database.addSubject(name);
    }
}
