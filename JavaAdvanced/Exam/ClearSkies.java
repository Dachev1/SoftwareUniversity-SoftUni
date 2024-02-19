package Exam;

import java.util.Scanner;

public class ClearSkies {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensionSize = Integer.parseInt(scanner.nextLine());

        String[][] airspace = new String[dimensionSize][dimensionSize];

        fillMatrix(scanner, airspace);

        int jetRow = 0;
        int jetCol = 0;

        for (int row = 0; row < airspace.length; row++) {
            for (int col = 0; col < airspace[row].length; col++) {
                if (airspace[row][col].equals("J")) {
                    jetRow = row;
                    jetCol = col;
                    break;
                }
            }
        }

        int enemyCount = 0;
        for (int row = 0; row < airspace.length; row++) {
            for (int col = 0; col < airspace[row].length; col++) {
                if (airspace[row][col].equals("E")) {
                    enemyCount++;
                }
            }
        }

        int armour = 300;

        while (true) {
            String direction = scanner.nextLine();

            airspace[jetRow][jetCol] = "-";

            switch (direction) {
                case "up":
                    jetRow--;
                    break;
                case "down":
                    jetRow++;
                    break;
                case "left":
                    jetCol--;
                    break;
                case "right":
                    jetCol++;
                    break;
            }

            if (airspace[jetRow][jetCol].equals("E")) {
                if (enemyCount != 1) {
                    armour -= 100;
                }
                enemyCount--;

                if (armour <= 0) {
                    airspace[jetRow][jetCol] = "J";
                    System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!\n", jetRow, jetCol);
                    break;
                }
            } else if (airspace[jetRow][jetCol].equals("R")) {
                armour = 300;
            }

            airspace[jetRow][jetCol] = "J";
            if (enemyCount == 0) {
                System.out.println("Mission accomplished, you neutralized the aerial threat!");
                break;
            }
        }

        for (int row = 0; row < airspace.length; row++) {
            for (int col = 0; col < airspace[row].length; col++) {
                System.out.print(airspace[row][col]);
            }

            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] airspace) {
        for (int row = 0; row < airspace.length; row++) {
            airspace[row] = scanner.nextLine().split("");
        }
    }
}
