package lab1.task1;

import lab1.task2.Course;
import lab1.task2.Student;
import lab1.task2.StudentAllocator;
import lab1.task4.DummyCalculator;

class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Mirica Denis");
        student1.setGrade(8.5);

        System.out.println("Student Name: " + student1.getName());
        System.out.println("Student Grade: " + student1.getGrade());

        Student[] students = StudentAllocator.createStudents();

        System.out.println("\nList with students:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Grade: " + student.getGrade());
        }

        Course javaCourse = new Course();
        javaCourse.setName("PAO");
        javaCourse.setMinimumGrade(7.0);
        javaCourse.setStudents(students);

        System.out.println("\nPassing students in " + javaCourse.getName() + ":");
        Student[] passingStudents = javaCourse.showAllPassingStudents();
        for (Student student : passingStudents) {
            if (student != null) {
                System.out.println("Name: " + student.getName() + ", Grade: " + student.getGrade());
            }
        }

        Student randomStudent = javaCourse.chooseStudentRandomly();
        System.out.println("\nRandomly chosen student: " + randomStudent.getName());

        Student studentToCheck = students[7];
        boolean isPassing = javaCourse.isStudentPassing(studentToCheck);
        System.out.println("\nIs " + studentToCheck.getName() + " passing ? " + isPassing);

        DummyCalculator dummyCalculator = new DummyCalculator();
        String[] testInputs = {
                "1 + 2",
                "1.0 + 1.2",
                "true & false",
                "1 * 2.0",
                "2 / 2"
        };

        for (String input : testInputs) {
            String[] operationArgs = input.split(" ");
            System.out.println("\nTesting input: " + input);
            dummyCalculator.calculate(operationArgs);
        }
    }
}