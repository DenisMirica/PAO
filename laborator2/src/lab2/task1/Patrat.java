package lab2.task1;

import lab2.task1.Dreptunghi;

public class Patrat extends Dreptunghi {
    public Patrat(int latura) {
        super(latura, latura);
    }

    @Override
    public double calculeazaArie() {
        return latura1 * latura1;
    }
}

