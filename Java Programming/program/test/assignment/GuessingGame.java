import java.util.Scanner;
import java.util.Random;

public class GuessingGame {
    public static void main(String[] args) {
        System.out.println("-------- Guessing Game --------\n");
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(10) + 1;
            int attempts = 3;
            int score = 0;
            boolean hasWon = false;

            System.out.println("\nI'm thinking of a number between 1 and 10.");
            System.out.println("You have " + attempts + " attempts to guess it.");

            for (int i = 1; i <= attempts; i++) {
                int userGuess = readGuess(scanner, i);

                if (userGuess == numberToGuess) {
                    hasWon = true;
                    score += 10; // Awarding 10 points for a correct guess
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }
            }

            System.out.println("\n--- Game Over ---");
            if (hasWon) {
                System.out.println("Congratulations! You guessed the right number.");
                System.out.println("Points Awarded: " + score);
            } else {
                System.out.println("Out of attempts! The correct number was: " + numberToGuess);
                System.out.println("Points Awarded: " + score);
            }

            playAgain = askRestartOrQuit(scanner);
        }

        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }

    private static int readGuess(Scanner scanner, int attempt) {
        while (true) {
            System.out.print("Attempt " + attempt + ": Enter your guess: ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Error: No input entered. Please enter a number between 1 and 10.");
                continue;
            }
            try {
                int guess = Integer.parseInt(input);
                if (guess < 1 || guess > 10) {
                    System.out.println("Error: Please enter a number between 1 and 10.");
                    continue;
                }
                return guess;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
            }
        }
    }

    private static boolean askRestartOrQuit(Scanner scanner) {
        while (true) {
            System.out.print("Would you like to restart or quit? (r/q): ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.isEmpty()) {
                System.out.println("Please enter 'r' to restart or 'q' to quit.");
                continue;
            }
            char answer = choice.charAt(0);
            if (answer == 'r') {
                return true;
            }
            if (answer == 'q') {
                return false;
            }
            System.out.println("Invalid choice. Please enter 'r' to restart or 'q' to quit.");
        }
    }
}
