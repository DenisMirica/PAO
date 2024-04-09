package task1;

public class Student {
    private String name;
    private double labGrade;
    private double partialGrade;
    private double examGrade;

    public Student(String name, double labGrade, double partialGrade, double examGrade) {
        this.name = name;
        this.labGrade = labGrade;
        this.partialGrade = partialGrade;
        this.examGrade = examGrade;
    }

    public double getTotalGrade() {
        return labGrade + partialGrade + examGrade;
    }

    public double getPartialGrade() {
        return partialGrade;
    }

    public double getAverageGrade() {
        return (labGrade + partialGrade + examGrade) / 3;
    }

    @Override
    public String toString() {
        return String.format("%s %.1f %.1f %.1f", name, labGrade, partialGrade, examGrade);
    }
}
