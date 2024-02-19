package ExamPreparation.August_19_2020;

import java.util.Scanner;

public class Bee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimmSize = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[dimmSize][dimmSize];

        fillMatrix(scanner, matrix);

        int beeRow = 0;
        int beeCol = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals("B")) {
                    beeRow = row;
                    beeCol = col;
                    break;
                }
            }
        }

        String command = scanner.nextLine();
        int pollinatedFlowers = 0;
        while (!"End".equals(command)) {
            matrix[beeRow][beeCol] = ".";

            switch (command) {
                case "up":
                    beeRow--;
                    break;
                case "down":
                    beeRow++;
                    break;
                case "left":
                    beeCol--;
                    break;
                case "right":
                    beeCol++;
                    break;
            }

            if (isOut(dimmSize, dimmSize, beeRow, beeCol)) {
                System.out.println("The bee got lost!");
                break;
            }

            if (matrix[beeRow][beeCol].equals("f")) {
                pollinatedFlowers++;
            } else if (matrix[beeRow][beeCol].equals("O")) {
                command = command;
                continue;
            }

            matrix[beeRow][beeCol] = "B";
            command = scanner.nextLine();
        }

        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", Math.abs(pollinatedFlowers - 5));
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }

            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] field) {
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("");
        }
    }

    private static boolean isOut(int rows, int cols, int beeRow, int beeCol) {
        return beeCol < 0 || beeCol >= cols || beeRow < 0 || beeRow >= rows;
    }
}
