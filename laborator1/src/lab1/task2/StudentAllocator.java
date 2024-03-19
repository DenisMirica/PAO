package lab1.task2;

public class StudentAllocator {
    public static Student[] createStudents(){
        Student[] checkStudents = new Student[10];
        for(int i = 0; i < 10;i++){
            String name = "Student" + i;
            double grade = 5 + (i * 0.5);
            Student student = new Student();
            student.setName(name);
            student.setGrade(grade);
            checkStudents[i] = student;
        }
        return checkStudents;
    }
}
