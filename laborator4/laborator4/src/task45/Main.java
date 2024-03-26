package task45;

public class Main {
    public static void main(String[] args) {
        System.out.println("foo:");
        foo();
        System.out.println("\nbar:");
        bar();
    }
    public static void foo() {
        try {
            System.out.println("1");
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("2");
        }

        System.out.println("3");
    }

    public static void bar() {
        try {
            throw new ClassCastException();
        } catch (RuntimeException e) {
            if (!(e instanceof ClassCastException)) {
                System.out.println("fail");
            }
        }
    }
}
