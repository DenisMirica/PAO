package task3;

public class Client {
    private final String name;
    private final double funds;

    public Client(String name, double funds) {
        this.name = name;
        this.funds = funds;
    }

    public String getName() {
        return name;
    }

    public double getFunds() {
        return funds;
    }
}

