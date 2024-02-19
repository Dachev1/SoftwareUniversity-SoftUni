package ExamPreparation.February_18_2023;

import java.util.Arrays;
import java.util.Scanner;

public class BlindMansBuff {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] playground = new String[rows][cols];

        fillTheMatrix(scanner, playground);

        int playerRow = 0;
        int playerCol = 0;

        for (int row = 0; row < playground.length; row++) {
            for (int col = 0; col < playground[row].length; col++) {
                if (playground[row][col].equals("B")) {
                    playerRow = row;
                    playerCol = col;
                    break;
                }
            }
        }

        String line;
        int touchedPeople = 0;
        int moves = 0;

        while (!"Finish".equals(line = scanner.nextLine())) {
            int oldRow = playerRow;
            int oldCol = playerCol;

            if (!playground[playerRow][playerCol].equals("O") && isOut(rows, cols, playerRow, playerCol)) {
                playground[playerRow][playerCol] = "-";
            }

            switch (line) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "left":
                    playerCol--;
                    break;
                case "right":
                    playerCol++;
                    break;
            }

            if (isOut(rows, cols, playerRow, playerCol)) {
                playerRow = oldRow;
                playerCol = oldCol;
                continue;
            }

            if (playground[playerRow][playerCol].equals("O")) {
                playerRow = oldRow;
                playerCol = oldCol;
                continue;
            } else if (playground[playerRow][playerCol].equals("P")) {
                touchedPeople++;
            }

            moves++;
            playground[playerRow][playerCol] = "B";

            if (touchedPeople == 3) {
                break;
            }
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %s Moves made: %d\n", touchedPeople, moves);
    }

    private static void fillTheMatrix(Scanner scanner, String[][] playground) {
        for (int row = 0; row < playground.length; row++) {
            playground[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean isOut(int rows, int cols, int playerRow, int playerCol) {
        return playerCol < 0 || playerCol >= cols || playerRow < 0 || playerRow >= rows;
    }
}
