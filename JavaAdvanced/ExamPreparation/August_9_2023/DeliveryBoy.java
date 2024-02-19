package ExamPreparation.August_9_2023;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // creating the matrix
        int[] dimmSize = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimmSize[0];
        int cols = dimmSize[1];

        String[][] neighborhood = new String[rows][cols];

        // representing the neighborhood area
        for (int row = 0; row < rows; row++) {
            neighborhood[row] = scanner.nextLine().split("");
        }

        // get the delivery boy start position
        int boyRow = 0;
        int boyCol = 0;

        for (int row = 0; row < neighborhood.length; row++) {
            for (int col = 0; col < neighborhood[row].length; col++) {
                if (neighborhood[row][col].equals("B")) {
                    boyRow = row;
                    boyCol = col;
                    break;
                }
            }
        }


        boolean isPizzaCollect = false;
        int boyStartRow = boyRow;
        int boyStartCol = boyCol;

        while (true) {
            String line = scanner.nextLine();
            if (!neighborhood[boyRow][boyCol].equals("R") && !neighborhood[boyRow][boyCol].equals("*")) {
                neighborhood[boyRow][boyCol] = ".";
            }

            switch (line) {
                case "up":
                    boyRow--;
                    break;
                case "down":
                    boyRow++;
                    break;
                case "right":
                    boyCol++;
                    break;
                case "left":
                    boyCol--;
                    break;
            }

            if (isBoyInHood(rows, cols, boyRow, boyCol)) {
                System.out.println("The delivery is late. Order is canceled.");
                for (int row = 0; row < neighborhood.length; row++) {
                    for (int col = 0; col < neighborhood[row].length; col++) {
                        if (row == boyStartRow && col == boyStartCol) {
                            neighborhood[row][col] = " ";
                        }

                        System.out.print(neighborhood[row][col]);
                    }

                    System.out.println();
                }
                return;
            }

            if (neighborhood[boyRow][boyCol].equals("P")) {
                System.out.println("Pizza is collected. 10 minutes for delivery.");
                neighborhood[boyRow][boyCol] = "R";
                isPizzaCollect = true;
                continue;
            } else if (neighborhood[boyRow][boyCol].equals("*")) {
                switch (line) {
                    case "up":
                        boyRow++;
                        break;
                    case "down":
                        boyRow--;
                        break;
                    case "right":
                        boyCol--;
                        break;
                    case "left":
                        boyCol++;
                        break;
                }
            }

            if (isPizzaCollect && neighborhood[boyRow][boyCol].equals("A")) {
                neighborhood[boyRow][boyCol] = "P";
                System.out.println("Pizza is delivered on time! Next order...");
                break;
            }
        }

        for (int row = 0; row < neighborhood.length; row++) {
            for (int col = 0; col < neighborhood[row].length; col++) {
                if (row == boyStartRow && col == boyStartCol) {
                    neighborhood[row][col] = "B";
                }

                System.out.print(neighborhood[row][col]);
            }

            System.out.println();
        }
    }
    private static boolean isBoyInHood(int rows, int cols, int boyRow, int boyCol) {
        return boyCol < 0 || boyCol >= cols || boyRow < 0 || boyRow >= rows;
    }
}
