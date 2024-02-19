package ExamPreparation.August_18_2021;

import java.util.Scanner;

public class FormulaOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        fillMatrix(scanner, matrix);

        int playerRow = 0;
        int playerCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("P")) {
                    playerRow = row;
                    playerCol = col;
                    break;
                }
            }
        }

        String command = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            int oldRow = playerRow;
            int oldCol = playerCol;

            if (!matrix[playerRow][playerCol].equals("B")) {
                matrix[playerRow][playerCol] = ".";
            }

            switch (command) {
                case "up":
                    playerRow--;
                    break;
                case "down":
                    playerRow++;
                    break;
                case "right":
                    playerCol++;
                    break;
                case "left":
                    playerCol--;
                    break;
            }

            if (playerCol < 0) {
                playerCol = size - 1;
            } else if (playerCol > size - 1) {
                playerCol = 0;
            }

            if (playerRow < 0) {
                playerRow = size - 1;
            } else if (playerRow > size - 1) {
                playerRow = 0;
            }

            if (matrix[playerRow][playerCol].equals("B")) {
                if (i >= 0) {
                    i--;
                }
                command = command;
                continue;
            } else if (matrix[playerRow][playerCol].equals("T")) {
                playerRow = oldRow;
                playerCol = oldCol;
            } else if (matrix[playerRow][playerCol].equals("F")) {
                System.out.println("Well done, the player won first place!");
                break;
            } else if (i == n - 1) {
                System.out.println("Oh no, the player got lost on the track!");
                break;
            }

            matrix[playerRow][playerCol] = "P";
            command = scanner.nextLine();
        }

        matrix[playerRow][playerCol] = "P";

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }

            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
