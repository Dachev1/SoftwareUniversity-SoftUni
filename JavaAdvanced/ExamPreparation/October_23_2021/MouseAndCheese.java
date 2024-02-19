package ExamPreparation.October_23_2021;

import java.util.Scanner;

public class MouseAndCheese {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimmSize = Integer.parseInt(scanner.nextLine());

        String[][] mouseTerritory = new String[dimmSize][dimmSize];

        fillMatrix(scanner, mouseTerritory);

        int mouseRow = 0;
        int mouseCol = 0;

        for (int row = 0; row < mouseTerritory.length; row++) {
            for (int col = 0; col < mouseTerritory[row].length; col++) {
                if (mouseTerritory[row][col].equals("M")) {
                    mouseRow = row;
                    mouseCol = col;
                    break;
                }
            }
        }


        String direction = scanner.nextLine();
        int cheese = 0;
        while (!"end".equals(direction)) {

            mouseTerritory[mouseRow][mouseCol] = "-";

            switch (direction) {
                case "up":
                    mouseRow--;
                    break;
                case "down":
                    mouseRow++;
                    break;
                case "left":
                    mouseCol--;
                    break;
                case "right":
                    mouseCol++;
                    break;
            }

            if (isOut(dimmSize, dimmSize, mouseRow, mouseCol)) {
                System.out.println("Where is the mouse?");
                break;
            }

            if (mouseTerritory[mouseRow][mouseCol].equals("c")) {
                cheese++;
                direction = scanner.nextLine();
            } else if (mouseTerritory[mouseRow][mouseCol].equals("B")) {
                direction = direction;
            } else {
                direction = scanner.nextLine();
            }

            mouseTerritory[mouseRow][mouseCol] = "M";
        }

        if (cheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!\n", cheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.\n", Math.abs(cheese - 5));
        }

        printMatrix(mouseTerritory);
    }

    private static void printMatrix(String[][] mouseTerritory) {
        for (int row = 0; row < mouseTerritory.length; row++) {
            for (int col = 0; col < mouseTerritory[row].length; col++) {
                System.out.print(mouseTerritory[row][col]);
            }

            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] mouseTerritory) {
        for (int row = 0; row < mouseTerritory.length; row++) {
            mouseTerritory[row] = scanner.nextLine().split("");
        }
    }

    private static boolean isOut(int rows, int cols, int mouseRow, int mouseCol) {
        return mouseCol < 0 || mouseCol >= cols || mouseRow < 0 || mouseRow >= rows;
    }
}
