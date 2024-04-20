package implementations;

public class TheMatrix {
    private char[][] matrix;
    private char fillChar;
    private char startChar;
    private int startRow;
    private int startCol;

    public TheMatrix(char[][] matrix, char fillChar, int startRow, int startCol) {
        this.matrix = matrix;
        this.fillChar = fillChar;
        this.startRow = startRow;
        this.startCol = startCol;
        this.startChar = this.matrix[this.startRow][this.startCol];
    }

    public void solve() {
       fillTheMatrix(this.startRow, this.startCol);
    }

    public String toOutputString() {
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                builder.append(matrix[row][col]);
            }

            builder.append(System.lineSeparator());
        }

        return builder.toString().trim();
    }

    private void fillTheMatrix(int row, int col) {
        if (isOutOfBound(row, col) || matrix[row][col] != this.startChar) {
            return;
        }

        this.matrix[row][col] = fillChar;

        this.fillTheMatrix(row + 1, col);
        this.fillTheMatrix(row, col + 1);
        this.fillTheMatrix(row - 1, col);
        this.fillTheMatrix(row, col - 1);
    }

    private boolean isOutOfBound(int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }
}
