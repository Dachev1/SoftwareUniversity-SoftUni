import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        fillTheMatrix(matrix, scanner);

        int[] mistakenValueTokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int mistakenValueRow = mistakenValueTokens[0];
        int mistakenValueCol = mistakenValueTokens[1];

        fixedMatrix(matrix, mistakenValueRow, mistakenValueCol);
    }

    private static void fixedMatrix(int[][] matrix, int mistakenValueRow, int mistakenValueCol) {
        // може да тряба валидация на индексите
        int mistakenValue = matrix[mistakenValueRow][mistakenValueCol];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == mistakenValue) {
                    int newValue = 0;
                    if (col > 0) {
                        if (matrix[row][col - 1] != mistakenValue) {
                            newValue += matrix[row][col - 1];
                        }
                    }

                    if (col < matrix[row].length - 1) {
                        if (matrix[row][col + 1] != mistakenValue) {
                            newValue += matrix[row][col + 1];
                        }
                    }

                    if (row < matrix.length - 1) {
                        if (matrix[row + 1][col] != mistakenValue) {
                            newValue += matrix[row + 1][col];
                        }
                    }

                    if (row > 0) {
                        if (matrix[row - 1][col] != mistakenValue) {
                            newValue += matrix[row - 1][col];
                        }
                    }

                    System.out.print(newValue + " ");
                    continue;
                }

                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static void fillTheMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
