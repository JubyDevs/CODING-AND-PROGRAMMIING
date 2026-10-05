import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean startOver = true;

        while (startOver) {
            System.out.print("----------- Calculator -----------\n");
            double num1 = readDouble(scanner, "Enter first number: ");

            char operator = readOperator(scanner);

            double num2 = readDouble(scanner, "Enter second number: ");

            double result;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    System.out.println("Result: " + result);
                    break;
                case '-':
                    result = num1 - num2;
                    System.out.println("Result: " + result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println("Result: " + result);
                    break;
                case '/':
                    // Handle division by zero
                    if (num2 != 0) {
                        result = num1 / num2;
                        System.out.println("Result: " + result);
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operator entered.");
                    break;
            }

            while (true) {
                System.out.print("Do you want to perform another calculation? (y/n): ");
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    System.out.println("Please enter 'y' or 'n'.");
                    continue;
                }
                char continueChoice = Character.toLowerCase(line.charAt(0));
                if (continueChoice == 'y') {
                    break;
                } else {
                    startOver = false;
                    break;
                }
            }
        }

        scanner.close();
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            if (line == null || line.trim().isEmpty()) {
                System.out.println("Error: No input entered. Please enter a number.");
                continue;
            }
            try {
                return Double.parseDouble(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number. Please enter a valid numeric value.");
            }
        }
    }

    private static char readOperator(Scanner scanner) {
        while (true) {
            System.out.print("Enter an operator (+, -, *, /): ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Error: No operator entered. Please enter +, -, *, or /.\n");
                continue;
            }
            char op = line.charAt(0);
            if (op == '+' || op == '-' || op == '*' || op == '/') {
                return op;
            }
            System.out.println("Error: Invalid operator entered. Please enter +, -, *, or /.\n");
        }
    }
}
