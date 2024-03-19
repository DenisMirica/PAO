package lab1.task4;

public class DummyCalculator {

    public void calculate(String[] args) {
        if (args.length != 3) {
            System.out.println("Numar invalid de argumente. Formatul corect: [numar1] [operator] [numar2]");
            return;
        }

        try {
            double operand1;
            double operand2;

            if (args[0].equalsIgnoreCase("true") || args[0].equalsIgnoreCase("false")) {
                operand1 = Boolean.parseBoolean(args[0]) ? 1.0 : 0.0;
            } else {
                operand1 = Double.parseDouble(args[0]);
            }

            if (args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
                operand2 = Boolean.parseBoolean(args[2]) ? 1.0 : 0.0;
            } else {
                operand2 = Double.parseDouble(args[2]);
            }

            switch (args[1]) {
                case "+":
                    printResult(operand1 + operand2);
                    break;
                case "-":
                    printResult(operand1 - operand2);
                    break;
                case "*":
                    printResult(operand1 * operand2);
                    break;
                case "/":
                    if (operand2 != 0) {
                        printResult(operand1 / operand2);
                    } else {
                        System.out.println("Nu se poate imparti la zero.");
                    }
                    break;
                case "&":
                    printBooleanResult((operand1 != 0) && (operand2 != 0));
                    break;
                case "|":
                    printBooleanResult((operand1 != 0) || (operand2 != 0));
                    break;
                default:
                    System.out.println("Operator invalid. Folositi +, -, *, /, &, |");
            }
        } catch (NumberFormatException e) {
            System.out.println("Argumente invalide.");
        }
    }

    private void printResult(double result) {
        if (result % 1 == 0) {
            System.out.println("Rezultat: " + (int) result);
        } else {
            System.out.println("Rezultat: " + result);
        }
    }

    private void printBooleanResult(boolean result) {
        System.out.println("Rezultat logic: " + result);
    }
}