package task4;

import java.util.Map;

public class DisplayStudentSubjectsCommand implements Command {
    private Database database;
    private String studentName;

    public DisplayStudentSubjectsCommand(Database database, String studentName) {
        this.database = database;
        this.studentName = studentName;
    }

    @Override
    public void execute() {
        Map<String, Grade> studentGrades = database.getStudentGrades(studentName);
        if (studentGrades != null) {
            System.out.println("Grades for " + studentName + ":");
            for (Map.Entry<String, Grade> entry : studentGrades.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().getValue());
            }
        } else {
            System.out.println("Student " + studentName + " not found.");
        }
    }
}
