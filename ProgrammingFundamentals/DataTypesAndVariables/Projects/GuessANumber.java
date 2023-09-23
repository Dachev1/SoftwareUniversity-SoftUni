package ProgrammingFundamentals.DataTypesAndVariables.Projects;

import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Random randomNumber = new Random();
        int computerNumber = randomNumber.nextInt(100);

        while (true) {
            System.out.print("Guess a number between 1 and 100: ");
            try {
                int playerGuess = Integer.parseInt(scanner.next());
                if (playerGuess == computerNumber) {
                    System.out.println("You guessed it");
                    break;
                } else if (playerGuess > computerNumber) {
                    System.out.println("Too high");
                } else {
                    System.out.println("Too low");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number :)");
            }
        }
    }
}
