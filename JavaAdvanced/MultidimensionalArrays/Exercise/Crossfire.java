package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimension[0];
        int cols = dimension[1];

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(matrix, rows, cols);

        String line;
        while (!"Nuke it from orbit".equals(line = scanner.nextLine())) {
             String[] tokens = line.split("\\s+");

             int row = Integer.parseInt(tokens[0]);
             int col = Integer.parseInt(tokens[1]);
             int radius = Integer.parseInt(tokens[2]);

            removeElements(matrix, row, col, radius);
            matrix.removeIf(List::isEmpty);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> row : matrix) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }

            System.out.println();
        }
    }

    private static void removeElements(List<List<Integer>> matrix, int row, int col, int radius) {
        // up, down
        for (int currentRow = row - radius; currentRow <= row + radius; currentRow++) {
            if (currentRow >= 0 && currentRow < matrix.size()) {
                if (currentRow == row) {
                    // left, right
                    for (int currentCol = col + radius; currentCol >= col - radius; currentCol--) {
                        if (isInMatrix(matrix, row, currentCol)) {
                            matrix.get(row).remove(currentCol);
                        }
                    }
                } else {
                    if (isInMatrix(matrix, currentRow, col)) {
                        matrix.get(currentRow).remove(col);
                    }
                }
            }
        }
    }

    private static boolean isInMatrix(List<List<Integer>> matrix, int row, int col) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int number = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(number++);
            }
        }
    }
}
