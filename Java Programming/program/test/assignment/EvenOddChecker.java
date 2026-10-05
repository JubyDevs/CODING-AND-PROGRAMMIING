import java.util.Scanner;

public class EvenOddChecker {
    public static void main(String[] args) {
        System.out.print("-------- Even or Odd number checker --------\n");

        Scanner scanner = new Scanner(System.in);
        int number;

        while (true) {
            System.out.print("Enter an integer: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: No input entered. Please enter an integer.");
                continue;
            }

            try {
                number = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid integer.");
            }
        }
        while (true) {
            System.out.print("Enter an integer: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Error: No input entered. Please enter an integer.");
                continue;
            }

            try {
                number = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid integer.");
            }
        }

        // If the remainder is 0 when divided by 2, it's even
        if (number % 2 == 0) {
            System.out.println(number + " is an Even number.");
        } else {
            System.out.println(number + " is an Odd number.");
        }

        scanner.close();
    }
}
