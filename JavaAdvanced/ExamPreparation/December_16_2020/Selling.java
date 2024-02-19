package ExamPreparation.December_16_2020;

import java.util.Scanner;

public class Selling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] bakery = new String[size][size];

        fillMatrix(scanner, bakery);

        int sRow = 0;
        int sCol = 0;

        for (int row = 0; row < bakery.length; row++) {
            for (int col = 0; col < bakery[row].length; col++) {
                if (bakery[row][col].equals("S")) {
                    sRow = row;
                    sCol = col;
                    break;
                }
            }
        }

        int money = 0;
        while (money < 50) {
            String direction = scanner.nextLine();
            bakery[sRow][sCol] = "-";

            switch (direction) {
                case "up":
                    sRow--;
                    break;
                case "down":
                    sRow++;
                    break;
                case "left":
                    sCol--;
                    break;
                case "right":
                    sCol++;
                    break;
            }

            if (isOut(size, size, sRow, sCol)) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }

            if (bakery[sRow][sCol].chars().allMatch(Character::isDigit)) {
                money += Integer.parseInt(bakery[sRow][sCol]);
            } else if (bakery[sRow][sCol].equals("O")) {
                bakery[sRow][sCol] = "-";

                for (int row = 0; row < bakery.length; row++) {
                    for (int col = 0; col < bakery[row].length; col++) {
                        if (bakery[row][col].equals("O")) {
                            sRow = row;
                            sCol = col;
                            break;
                        }
                    }
                }
            }

            bakery[sRow][sCol] = "S";
            if (money >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
        }

        System.out.println("Money: " + money);

        for (int row = 0; row < bakery.length; row++) {
            for (int col = 0; col < bakery[row].length; col++) {
                System.out.print(bakery[row][col]);
            }

            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] bakery) {
        for (int row = 0; row < bakery.length; row++) {
            bakery[row] = scanner.nextLine().split("");
        }
    }

    private static boolean isOut(int rows, int cols, int sRow, int sCol) {
        return sCol < 0 || sCol >= cols || sRow < 0 || sRow >= rows;
    }
}
