import java.util.*;
import java.util.stream.Collectors;

public class PrintDiagonalsOfSquareMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        readMatrix(matrix, scanner);

        printDiagonals(matrix);
    }

    private static void printDiagonals(int[][] matrix) {
        List<Integer> primaryDiagonal = new ArrayList<>();
        List<Integer> secondaryDiagonal = new ArrayList<>();

        getPrimaryDiagonal(primaryDiagonal, matrix);
        getSecondaryDiagonal(secondaryDiagonal, matrix);

        System.out.println(primaryDiagonal.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        System.out.println(secondaryDiagonal.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }

    private static void getSecondaryDiagonal(List<Integer> secondaryDiagonal, int[][] matrix) {
        int k = matrix.length - 1;

        for (int i = 0; i < matrix.length; i++) {
            secondaryDiagonal.add(matrix[i][k--]);
        }

        Collections.reverse(secondaryDiagonal);
    }

    private static void getPrimaryDiagonal(List<Integer> primaryDiagonal, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            primaryDiagonal.add(matrix[i][i]);
        }
    }

    private static void readMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
