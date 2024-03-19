package lab2.task1;

public class Dreptunghi extends Paralelogram {
    public Dreptunghi(int latura1, int latura2) {
        super(latura1, latura2, latura1, latura2, 90, 90, 90, 90);
    }


    @Override
    public double calculeazaArie() {
        return latura1 * latura2;
    }
}

