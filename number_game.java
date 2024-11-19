import java.util.*;

public class number_game {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0, TotalScores = 0;
        boolean playAgain = true;
        final int maxAttempt = 7;
        while (playAgain) {
            rounds++;
            int number_to_guess = random.nextInt(100) + 1;
            int attempt = 0;
            System.out.println("Round " + rounds + " has started!, You have " + maxAttempt + " attempts left");
            while (attempt < maxAttempt) {
                System.out.print("Enter your guess (number between 1 an 100) :");
                int guess = scn.nextInt();
                if (guess < 1 || guess > 100) {
                    System.out.println("Your guess is out of bounds, Choose guess between 1 to 100");
                    continue;
                }
                if (guess == number_to_guess) {
                    System.out.println("Correct! You guess the number in " + (attempt + 1) + " attempts.");
                    TotalScores = maxAttempt - attempt + 1;
                    break;
                }
                String highOrLow = (guess - number_to_guess > 0) ? "high" : "low";
                System.out.println("Too " + highOrLow + ", Try again");
                attempt++;
            }
            if (attempt == maxAttempt)
                System.out.println(
                    "Sorry, You've used all " + maxAttempt + " attempts. The correct number was "
                    + number_to_guess + "."
                );

            System.out.print("Do you want to play another round ? (yes/no) ");
            String playAgainInput = scn.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }
        System.out.println(
            "Game over!, You have played " + rounds + " rounds and your total score is " + TotalScores + "."
        );
        scn.close();
    }

}