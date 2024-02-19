package ExamPreparation.December_14_2022;

import java.util.Scanner;

public class NavyBattle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimmSize = Integer.parseInt(scanner.nextLine());

        String[][] battlefield = new String[dimmSize][];

        fillTheMatrix(scanner, battlefield);

        int submarineRow = 0;
        int submarineCol = 0;

        for (int row = 0; row < battlefield.length; row++) {
            for (int col = 0; col < battlefield[row].length; col++) {
                if (battlefield[row][col].equals("S")) {
                    submarineRow = row;
                    submarineCol = col;
                }
            }
        }

        int minesHit = 0;
        boolean isOut = false;
        int oldRow = 0;
        int oldCol = 0;

        while (minesHit != 3) {
            boolean isWon = true;
            String direction = scanner.nextLine();

            battlefield[submarineRow][submarineCol] = "-";

            switch (direction) {
                case "up":
                    submarineRow--;
                    break;
                case "down":
                    submarineRow++;
                    break;
                case "left":
                    submarineCol--;
                    break;
                case "right":
                    submarineCol++;
                    break;
            }

            if (isOut(dimmSize, dimmSize, submarineRow, submarineCol)) {
                oldRow = submarineRow;
                oldCol = submarineCol;
                isOut = true;
                break;
            }
            if (battlefield[submarineRow][submarineCol].equals("*")) {
                oldRow = submarineRow;
                oldCol = submarineCol;
                minesHit++;
            } else if (battlefield[submarineRow][submarineCol].equals("C")) {
                battlefield[submarineRow][submarineCol] = "-";

                for (int row = 0; row < battlefield.length; row++) {
                    for (int col = 0; col < battlefield[row].length; col++) {
                        if (battlefield[row][col].equals("C")) {
                            isWon = false;
                            break;
                        }
                    }
                }

                if (isWon) {
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    battlefield[submarineRow][submarineCol] = "S";
                    break;
                }
            }

            battlefield[submarineRow][submarineCol] = "S";
        }

        if (isOut || minesHit == 3) {
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!\n", oldRow, oldCol);
        }

        printMatrix(battlefield);
    }

    private static void printMatrix(String[][] battlefield) {
        for (int row = 0; row < battlefield.length; row++) {
            for (int col = 0; col < battlefield[row].length; col++) {
                System.out.print(battlefield[row][col]);
            }

            System.out.println();
        }
    }

    private static void fillTheMatrix(Scanner scanner, String[][] battlefield) {
        for (int row = 0; row < battlefield.length; row++) {
            battlefield[row] = scanner.nextLine().split("");
        }
    }

    private static boolean isOut(int rows, int cols, int submarineRow, int submarineCol) {
        return submarineCol < 0 || submarineCol >= cols || submarineRow < 0 || submarineRow >= rows;
    }
}
