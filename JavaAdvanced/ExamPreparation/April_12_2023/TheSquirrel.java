package ExamPreparation.April_12_2023;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheSquirrel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int collectedHazelnuts = 0;

        int size = Integer.parseInt(scanner.nextLine());

        String[][] field = new String[size][size];

        List<String> directions = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        fillTheMatrix(scanner, field);

        int squirrelRow = 0;
        int squirrelCol = 0;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("s")) {
                    squirrelRow = row;
                    squirrelCol = col;
                    break;
                }
            }
        }

        boolean isStepOnTrap = false;
        for (String direction : directions) {
            field[squirrelRow][squirrelCol] = "*";
            switch (direction) {
                case "left":
                    squirrelCol--;
                    break;
                case "right":
                    squirrelCol++;
                    break;
                case "down":
                    squirrelRow++;
                    break;
                case "up":
                    squirrelRow--;
                    break;
            }

            if (isOut(size, squirrelRow, squirrelCol)) {
                System.out.println("The squirrel is out of the field.");
                break;
            }

            switch (field[squirrelRow][squirrelCol]) {
                case "h":
                    collectedHazelnuts++;
                    break;
                case "t":
                   isStepOnTrap = true;
                    break;
            }

            if (isStepOnTrap) {
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                break;
            }

            field[squirrelRow][squirrelCol] = "s";
        }

        if (collectedHazelnuts == 3) {
            System.out.println("Good job! You have collected all hazelnuts!");
        } else if (!isStepOnTrap && !isOut(size, squirrelRow, squirrelCol)) {
            System.out.println("There are more hazelnuts to collect.");
        }

        System.out.println("Hazelnuts collected: " + collectedHazelnuts);

    }

    private static boolean isOut(int size, int squirrelRow, int squirrelCol) {
        return squirrelCol < 0 || squirrelCol >= size || squirrelRow < 0 || squirrelRow >= size;
    }

    private static void fillTheMatrix(Scanner scanner, String[][] field) {
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("");
        }
    }
}
