import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lowerLimit = 1;
        int upperLimit = 100;
        int attemptsLimit = 10;
        int score = 0;

        System.out.println("Welcome to Guess the Number Game!");

        do {
            int generatedNumber = generateRandomNumber(lowerLimit, upperLimit);
            System.out.println("\nI have generated a number between " + lowerLimit + " and " + upperLimit + ". Try to guess it!");

            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (guessedCorrectly) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                score += attempts;
                
            } else {
                System.out.println("Sorry! You've reached the maximum number of attempts. The correct number was: " + generatedNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Your total score is: " + score);
        scanner.close();
    }

    private static int generateRandomNumber(int lowerLimit, int upperLimit) {
        return lowerLimit + (int) (Math.random() * (upperLimit - lowerLimit + 1));
    }
}
