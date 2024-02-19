package ExamPreparation.June_25_2022;

import java.util.*;
import java.util.stream.Collectors;

public class StickyFingers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

//        Deque<String> directions = new ArrayDeque<>();
//        Arrays.stream(scanner.nextLine().split(","))
//                .forEach(directions::offer);
        List<String> directions = Arrays.stream(scanner.nextLine().split(",")).collect(Collectors.toList());

        String[][] field = new String[fieldSize][fieldSize];

        fillMatrix(scanner, field);

        // get Dillinger row & col
        int dillingerRow = 0;
        int dillingerCol = 0;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (field[row][col].equals("D")) {
                    dillingerRow = row;
                    dillingerCol = col;
                    break;
                }
            }
        }

        int stolenMoney = 0;
        for (int i = 0; i < directions.size(); i++) {
            String direction = directions.get(i);

            int lastRow = dillingerRow;
            int lastCol = dillingerCol;

            field[dillingerRow][dillingerCol] = "+";

            switch (direction) {
                case "up":
                    dillingerRow--;
                    break;
                case "down":
                    dillingerRow++;
                    break;
                case "left":
                    dillingerCol--;
                    break;
                case "right":
                    dillingerCol++;
                    break;
            }

            if (isOut(fieldSize, fieldSize, dillingerRow, dillingerCol)) {
                System.out.println("You cannot leave the town, there is police outside!");
                dillingerRow = lastRow;
                dillingerCol = lastCol;
                continue;
            }

            if (field[dillingerRow][dillingerCol].equals("$")) {
                field[dillingerRow][dillingerCol] = "+";
                int robedMoney = dillingerRow * dillingerCol;
                stolenMoney += robedMoney;
                System.out.printf("You successfully stole %d$.\n", robedMoney);
            } else if (field[dillingerRow][dillingerCol].equals("P")) {
                field[dillingerRow][dillingerCol] = "#";
                System.out.printf("You got caught with %d$, and you are going to jail.\n", stolenMoney);
                break;
            }

            field[dillingerRow][dillingerCol] = "D";
            if (i == directions.size() - 1) {
                System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
            }
        }
        printMatrix(field);
    }

    private static void printMatrix(String[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] field) {
        for (int row = 0; row < field.length; row++) {
            field[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean isOut(int rows, int cols, int dillingerRow, int dillingerCol) {
        return dillingerCol < 0 || dillingerCol > cols - 1 || dillingerRow < 0 || dillingerRow > rows - 1;
    }
}
