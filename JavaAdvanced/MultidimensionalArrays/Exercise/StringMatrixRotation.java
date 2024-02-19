package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rotation = Integer.parseInt(scanner.nextLine().split("[()]")[1]);
        int rotations = rotation % 360;

        List<String> words = new ArrayList<>();
        String line;
        int maxLength = 0;

        while (!"END".equals(line = scanner.nextLine())) {
            words.add(line);

            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }

        int rows = words.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        readMatrix(matrix, words);



        switch (rotations) {
            case 90:
            matrix = rotate90(matrix, rows, cols);
                break;
            case 180:
                matrix = rotate90(matrix, rows, cols);
                matrix = rotate90(matrix, cols, rows);
                break;
            case 270:
                matrix = rotate90(matrix, rows, cols);
                matrix = rotate90(matrix, cols, rows);
                matrix = rotate90(matrix, rows, cols);
                break;
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }

            System.out.println();
        }
    }

    private static char[][] rotate90(char[][] matrix, int rows, int cols) {
        char[][] resultMatrix = new char[cols][rows];

        for (int col = 0; col < cols; col++) {
            int c = 0;
            for (int row = rows - 1; row >= 0; row--) {
                resultMatrix[col][c++] = matrix[row][col];
            }
        }

        return resultMatrix;
    }

    private static void readMatrix(char[][] matrix, List<String> words) {
        for (int row = 0; row < matrix.length; row++) {
            String word = words.get(row);
            for (int col = 0; col < matrix[row].length; col++) {
                if (col < word.length()) {
                    matrix[row][col] = word.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }
}
