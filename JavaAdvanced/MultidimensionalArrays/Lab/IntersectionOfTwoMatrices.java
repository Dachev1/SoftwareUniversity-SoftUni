import java.util.Scanner;

public class IntersectionOfTwoMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] resultMatrix = new String[rows][cols];

        String[][] firstMatrix = new String[rows][cols];
        String[][] secondMatrix = new String[rows][cols];

        readMatrix(firstMatrix, scanner);
        readMatrix(secondMatrix, scanner);

        printInteraction(firstMatrix, secondMatrix, resultMatrix);
    }

    private static void printInteraction(String[][] firstMatrix, String[][] secondMatrix, String[][] resultMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    resultMatrix[row][col] = firstMatrix[row][col];
                } else {
                    resultMatrix[row][col] = "*";
                }
            }
        }

        printMatrix(resultMatrix);
    }

    private static void printMatrix(String[][] resultMatrix) {
        for (int row = 0; row < resultMatrix.length; row++) {
            for (int col = 0; col < resultMatrix[row].length; col++) {
                System.out.print(resultMatrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static void readMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}
