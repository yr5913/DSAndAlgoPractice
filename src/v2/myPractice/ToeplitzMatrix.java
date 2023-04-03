package v2.myPractice;

public class ToeplitzMatrix {


    public boolean isToeplitzMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            if (!isDiagonalSame(matrix, i, 0)) {
                return false;
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (!isDiagonalSame(matrix, 0, i)) {
                return false;
            }
        }
        return true;

    }

    public boolean isDiagonalSame(int[][] matrix, int x, int y) {
        int value = matrix[x++][y++];
        while (x < matrix.length && y < matrix[0].length) {
            if (matrix[x++][y++] != value) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] array = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        new ToeplitzMatrix().isToeplitzMatrix(array);
    }
}
