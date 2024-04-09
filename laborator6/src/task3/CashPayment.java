package task3;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Plata cash in valoare de " + amount + " lei.");
    }
}
