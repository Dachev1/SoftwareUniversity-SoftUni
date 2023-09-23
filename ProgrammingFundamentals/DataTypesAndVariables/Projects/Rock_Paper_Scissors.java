package ProgrammingFundamentals.DataTypesAndVariables.Projects;

import java.util.Random;
import java.util.Scanner;

public class Rock_Paper_Scissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final String ROCK = "Rock";
        final String PAPER = "Paper";
        final String SCISSORS = "Scissors";

        System.out.print("Choose [r]ock, [p]aper or [s]cissors: ");
        String playerInput = scanner.next();

        if (playerInput.equals("r") || playerInput.equals("rock")) {
            playerInput = ROCK;
        } else if (playerInput.equals("p") || playerInput.equals("paper")) {
            playerInput = PAPER;
        } else if (playerInput.equals("s") || playerInput.equals("scissors")) {
            playerInput = SCISSORS;
        } else {
            System.out.println("Invalid Input. Try Again...");
            return;
        }

        Random random = new Random();
        int computerRandomNumber = random.nextInt(4);

        String computerMove = switch (computerRandomNumber) {
            case 1 -> ROCK;
            case 2 -> PAPER;
            case 3 -> SCISSORS;
            default -> "";
        };

        System.out.printf("The computer chose %s.%n", computerMove);

        if (playerInput.equals(ROCK) && computerMove.equals(SCISSORS) ||
                playerInput.equals(PAPER) && computerMove.equals(ROCK) ||
                playerInput.equals(SCISSORS) && computerMove.equals(PAPER)) {
            System.out.println("You win.");
        } else if (playerInput.equals(ROCK) && computerMove.equals(PAPER) ||
                playerInput.equals(PAPER) && computerMove.equals(SCISSORS) ||
                playerInput.equals(SCISSORS) && computerMove.equals(ROCK)) {
            System.out.println("You lose.");
        } else {
            System.out.println("Draw");
        }
    }
}