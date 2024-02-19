package ExamPreparation.June_26_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Python {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pythonLength = 1;
        int size = Integer.parseInt(scanner.nextLine());

        List<String> directions = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .collect(Collectors.toList());

        String[][] field = new String[size][size];
        fillMatrix(scanner, field);

        int snakeRow = 0;
        int snakeCol = 0;
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("s")) {
                    snakeRow = row;
                    snakeCol = col;
                    break;
                }
            }
        }

        int foodCount = 0;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("f")) {
                    foodCount++;
                }
            }
        }

        for (int i = 0; i < directions.size(); i++) {
            String direction = directions.get(i);

            field[snakeRow][snakeCol] = "*";

            switch (direction) {
                case "up":
                    snakeRow--;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
            }

            if (snakeRow > size - 1) {
                snakeRow = 0;
            } else if (snakeRow < 0) {
                snakeRow = size - 1;
            }

            if (snakeCol > size - 1) {
                snakeCol = 0;
            } else if (snakeCol < 0) {
                snakeCol = size - 1;
            }

            if (field[snakeRow][snakeCol].equals("f")) {
                foodCount--;
                pythonLength++;
            }

            if (field[snakeRow][snakeCol].equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }

            if (foodCount == 0) {
                System.out.printf("You win! Final python length is %d\n", pythonLength);
                return;
            }

            field[snakeRow][snakeCol] = "s";
        }


        System.out.printf("You lose! There is still %d food to be eaten.\n", foodCount);

    }

    private static void fillMatrix(Scanner scanner, String[][] field) {
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("\\s+");
        }
    }
}
