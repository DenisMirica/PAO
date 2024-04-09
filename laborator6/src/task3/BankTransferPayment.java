package task3;

public class BankTransferPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Plata prin transfer bancar in valoare de " + amount + " lei.");
    }
}

