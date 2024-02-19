package ExamPreparation.April_13_2022;

import java.util.Scanner;

public class Armory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        String[][] armory = new String[matrixSize][matrixSize];

        fillMatrix(scanner, armory);

        // get officer row & col (markedd with "A")
        int officerRow = 0;
        int officerCol = 0;
        for (int row = 0; row < armory.length; row++) {
            for (int col = 0; col < armory[row].length; col++) {
                if (armory[row][col].equals("A")) {
                    officerRow = row;
                    officerCol = col;
                    break;
                }
            }
        }

        int coins = 0;

        while (coins < 65) {
            String direction = scanner.nextLine();

            armory[officerRow][officerCol] = "-";

            switch (direction) {
                case "up":
                    officerRow--;
                    break;
                case "down":
                    officerRow++;
                    break;
                case "left":
                    officerCol--;
                    break;
                case "right":
                    officerCol++;
                    break;
            }

            if (isOut(matrixSize, matrixSize, officerRow, officerCol)) {
                System.out.println("I do not need more swords!");
                break;
            }

            if (Character.isDigit(armory[officerRow][officerCol].charAt(0))) {
                coins += Integer.parseInt(armory[officerRow][officerCol]);
            } else if (armory[officerRow][officerCol].equals("M")) {
                armory[officerRow][officerCol] = "-";

                for (int row = 0; row < armory.length; row++) {
                    for (int col = 0; col < armory[row].length; col++) {
                        if (armory[row][col].equals("M")) {
                            officerRow = row;
                            officerCol = col;
                        }
                    }
                }
            }
            armory[officerRow][officerCol] = "A";
        }

        if (coins > 65) {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.\n", coins);

        printMatrix(armory);
    }

    private static void printMatrix(String[][] armory) {
        for (int row = 0; row < armory.length; row++) {
            for (int col = 0; col < armory[row].length; col++) {
                System.out.print(armory[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] armory) {
        for (int row = 0; row < armory.length; row++) {
            armory[row] = scanner.nextLine().split("");
        }
    }

    private static boolean isOut(int rows, int cols, int officerRow, int officerCol) {
        return officerCol < 0 || officerCol > cols - 1 || officerRow < 0 || officerRow > rows - 1;
    }
}
