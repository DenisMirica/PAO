package task3;

public class Transaction {
    private final double amount;
    private final PaymentStrategy paymentStrategy;

    public Transaction(double amount, PaymentStrategy paymentStrategy) {
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    public void execute() {
        paymentStrategy.pay(amount);
    }
}

