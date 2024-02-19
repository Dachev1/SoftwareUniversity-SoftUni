import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        int[][] matrix = new int[rows][cols];

        readMatrix(matrix, scanner);

        getBiggestTwoByTwoMatrix(matrix);
    }

    private static void getBiggestTwoByTwoMatrix(int[][] matrix) {

        int currentMax = Integer.MIN_VALUE;
        int[][] resultMatrix = new int[2][2];

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sum > currentMax) {
                    currentMax = sum;
                    resultMatrix[0][0] = matrix[row][col];
                    resultMatrix[0][1] = matrix[row][col + 1];
                    resultMatrix[1][0] = matrix[row + 1][col];
                    resultMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }

        printMatrix(resultMatrix);
        System.out.println(currentMax);
    }

    private static void printMatrix(int[][] resultMatrix) {
        for (int row = 0; row < resultMatrix.length; row++) {
            for (int col = 0; col < resultMatrix[row].length; col++) {
                System.out.print(resultMatrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static void readMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
