package ExamPreparation.February_20_2021;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimensionSize = Integer.parseInt(scanner.nextLine());

        String[][] field = new String[dimensionSize][dimensionSize];

        List<String> directions = Arrays.stream(scanner.nextLine().split(","))
                        .collect(Collectors.toList());

        fillMatrix(scanner, field);

        int sapperRow = 0;
        int sapperCol = 0;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("s")) {
                    sapperRow = row;
                    sapperCol = col;
                    break;
                }
            }
        }

        int allBombs = 0;
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("B")) {
                    allBombs++;
                }
            }
        }


        for (int i = 0; i < directions.size(); i++) {
            String direction = directions.get(i);

            int oldRow = sapperRow;
            int oldCol = sapperCol;

            switch (direction) {
                case "up":
                    sapperRow--;
                    break;
                case "down":
                    sapperRow++;
                    break;
                case "left":
                    sapperCol--;
                    break;
                case "right":
                    sapperCol++;
                    break;
            }

            if (sapperRow > dimensionSize - 1) {
                sapperRow = oldRow;
            } else if (sapperRow < 0) {
                sapperRow = oldRow;
            }

            if (sapperCol > dimensionSize - 1) {
                sapperCol = oldCol;
            } else if (sapperCol < 0) {
                sapperCol = oldCol;
            }

            if (field[sapperRow][sapperCol].equals("B")) {
                field[sapperRow][sapperCol] = "+";
                System.out.println("You found a bomb!");
                allBombs--;
            } else if (field[sapperRow][sapperCol].equals("e")) {
                System.out.printf("END! %d bombs left on the field\n", allBombs);
                return;
            }

            if (allBombs <= 0) {
                break;
            }
        }

        if (allBombs > 0) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)\n", allBombs, sapperRow, sapperCol);
        } else {
            System.out.println("Congratulations! You found all bombs!");
        }
    }
    private static void fillMatrix(Scanner scanner, String[][] field) {
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("\\s+");
        }
    }
}
