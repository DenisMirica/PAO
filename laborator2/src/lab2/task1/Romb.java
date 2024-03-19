package lab2.task1;

import lab2.task1.Paralelogram;

public class Romb extends Paralelogram {
    private int diagonalaMare;
    private int diagonalaMica;

    public Romb(int diagonalaMare, int diagonalaMica) {
        super(diagonalaMare, diagonalaMica, diagonalaMare, diagonalaMica, 60, 120, 60, 120);
        this.diagonalaMare = diagonalaMare;
        this.diagonalaMica = diagonalaMica;
    }

    @Override
    public double calculeazaArie() {
        return (diagonalaMare * diagonalaMica) / 2.0;
    }
}
