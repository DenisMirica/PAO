package task3;

public class CardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Plata cu cardul in valoare de " + amount + " lei.");
    }
}
