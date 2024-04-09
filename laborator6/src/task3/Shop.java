package task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shop {
    private final List<Transaction> dailyTransactions;

    public Shop() {
        this.dailyTransactions = new ArrayList<>();
    }

    public void addTransaction(double amount, Client client) {
        PaymentStrategy paymentStrategy = choosePaymentStrategy(client);
        Transaction transaction = new Transaction(amount, paymentStrategy);
        dailyTransactions.add(transaction);
    }

    public void executeTransactions() {
        for (Transaction transaction : dailyTransactions) {
            transaction.execute();
        }
    }

    private PaymentStrategy choosePaymentStrategy(Client client) {
        Random random = new Random();
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return new CashPayment();
            case 1:
                return new BankTransferPayment();
            case 2:
                return new CardPayment();
            default:
                throw new IllegalStateException("Optiune de plata invalida!");
        }
    }
}

