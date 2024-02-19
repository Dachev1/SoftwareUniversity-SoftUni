import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // firstMatrix
        int[] firstDimension = getIntegerArr(scanner);

        int firstMatrixRows = firstDimension[0];
        int firstMatrixCols = firstDimension[1];

        int[][] firstMatrix = new int[firstMatrixRows][firstMatrixCols];

        for (int row = 0; row < firstMatrixRows; row++) {
            firstMatrix[row] = getIntegerArr(scanner);
        }

        // secondMatrix
        int[] secondDimension = getIntegerArr(scanner);

        int secondMatrixRows = secondDimension[0];
        int secondMatrixCols = secondDimension[1];

        int[][] secondMatrix = new int[secondMatrixRows][secondMatrixCols];

        for (int row = 0; row < firstMatrixRows; row++) {
            secondMatrix[row] = getIntegerArr(scanner);
        }

        // compare the two matrix
        boolean areEqual = areEqual(firstMatrix, secondMatrix);
        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static boolean areEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row].length != secondMatrix[row].length) {
                    return false;
                }
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int[] getIntegerArr(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
