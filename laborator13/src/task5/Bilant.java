package task5;

public class Bilant implements Comparable<Bilant> {
    private int pozitive;
    private int negative;
    public Bilant() {
        this(0, 0);
    }

    public Bilant(int pozitive, int negative) {
        this.pozitive = pozitive;
        this.negative = negative;
    }

    public int getPozitive() {
        return pozitive;
    }

    public int getNegative() {
        return negative;
    }

    @Override
    public String toString() {
        return "task5.Bilant{" +
                "pozitive=" + pozitive +
                ", negative=" + negative +
                '}';
    }

    @Override
    public int compareTo(Bilant other) {
        int thisDiff = this.pozitive - this.negative;
        int otherDiff = other.pozitive - other.negative;
        return Integer.compare(otherDiff, thisDiff);
    }
}
