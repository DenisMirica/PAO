package task1;

public class SorterFactory {
    public SortStrategy createSorter(String type) {
        switch (type) {
            case "TotalGrade":
                return new TotalGradeSort();
            case "PartialGrade":
                return new PartialGradeSort();
            case "AverageGrade":
                return new AverageGradeSort();
            default:
                throw new IllegalArgumentException("Invalid sort type: " + type);
        }
    }
}
