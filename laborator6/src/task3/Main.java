package task3;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        Client cashClient = new Client("Cash Client", 100);
        shop.addTransaction(50, cashClient);

        Client bankTransferClient = new Client("Bank Transfer Client", 200);
        shop.addTransaction(60, bankTransferClient);

        Client cardClient = new Client("Card Client", 300);
        shop.addTransaction(70, cardClient);

        shop.executeTransactions();
    }
}
