package lab2.task1;

public class Main {
    public static void main(String[] args) {
        Paralelogram paralelogram = new Paralelogram(5, 10, 5, 10, 60, 120, 60, 120);
        System.out.println("Aria paralelogramului: " + paralelogram.calculeazaArie());

        Dreptunghi dreptunghi = new Dreptunghi(4, 8);
        System.out.println("Aria dreptunghiului: " + dreptunghi.calculeazaArie());

        Romb romb = new Romb(6, 8);
        System.out.println("Aria rombului: " + romb.calculeazaArie());

        Patrat patrat = new Patrat(6);
        System.out.println("Aria patratului: " + patrat.calculeazaArie());
    }
}
