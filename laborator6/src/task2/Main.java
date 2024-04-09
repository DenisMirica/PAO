package task2;

public class Main {
    public static void main(String[] args) {
        User adrian = new User("Adrian");
        User ion = new User("Ion");
        User maria = new User("Maria");
        User matei = new User("Matei");

        Topic gatit = new Topic("gatit");
        Topic programare = new Topic("programare");

        adrian.subscribeToTopic(gatit);
        maria.subscribeToTopic(gatit);
        ion.subscribeToTopic(programare);
        adrian.subscribeToTopic(programare);
        maria.subscribeToTopic(programare);
        matei.subscribeToTopic(programare);

        programare.sendMessage(ion, "Salutare!");
        gatit.sendMessage(adrian, "Omlette du fromage");
    }
}
