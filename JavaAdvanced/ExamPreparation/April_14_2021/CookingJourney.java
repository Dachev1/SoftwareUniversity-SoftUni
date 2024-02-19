package ExamPreparation.April_14_2021;

import java.util.Scanner;

public class CookingJourney {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] shop = new String[size][size];

        fillMatrix(scanner, shop);

        int sRow = 0;
        int sCol = 0;

        for (int row = 0; row < shop.length; row++) {
            for (int col = 0; col < shop[row].length; col++) {
                if (shop[row][col].equals("S")) {
                    sRow = row;
                    sCol = col;
                    break;
                }
            }
        }

        int money = 0;

        while (money < 50) {
            String direction = scanner.nextLine();

            shop[sRow][sCol] = "-";

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
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }

            if (shop[sRow][sCol].chars().allMatch(Character::isDigit)) {
                money += Integer.parseInt(shop[sRow][sCol]);
            } else if (shop[sRow][sCol].equals("P")) {
                shop[sRow][sCol] = "-";
                for (int row = 0; row < shop.length; row++) {
                    for (int col = 0; col < shop[row].length; col++) {
                        if (shop[row][col].equals("P")) {
                            sRow = row;
                            sCol = col;
                            break;
                        }
                    }
                }
            }

            shop[sRow][sCol] = "S";
        }

        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.println("Money: " + money);

        printMatrix(shop);
    }

    private static void printMatrix(String[][] shop) {
        for (int row = 0; row < shop.length; row++) {
            for (int col = 0; col < shop[row].length; col++) {
                System.out.print(shop[row][col]);
            }

            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] shop) {
        for (int row = 0; row < shop.length; row++) {
            shop[row] = scanner.nextLine().split("");
        }
    }

    private static boolean isOut(int rows, int cols, int sRow, int sCol) {
        return sCol < 0 || sCol >= cols || sRow < 0 || sRow >= rows;
    }
}
