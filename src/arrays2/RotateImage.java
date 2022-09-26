package arrays2;

public class RotateImage {
    /**
     * https://leetcode.com/problems/rotate-image/solution/
     **/
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int start = 0;
        int[][] points = new int[4][2];
        points[0][1] = 1;
        points[1][0] = 1;
        points[2][1] = -1;
        points[3][0] = -1;
        int row = 0;
        int end = length - 1;
        while (end - start > 0) {
            for (int i = start; i < end; i++) {
                rotate(start, i, start, end, matrix, points);
            }
            row++;
            start++;
            end--;
            length -= 2;

        }
    }

    private void rotate(int row, int col, int start, int end, int[][] matrix, int[][] points) {

        int j = 0;
        int temp = matrix[row][col];
        int currCol = col;
        int currRow = row;
        for (int i = 0; i < 3; i++) {
            int k = end - start;
            while (k > 0) {
                int diff = Math.min(k, end - currRow);
                if (points[j][1] == 1) {
                    diff = Math.min(k, end - currCol);
                } else if (points[j][1] == -1)
                    diff = Math.min(k, currCol - start);
                else if (points[j][0] == -1)
                    diff = Math.min(k, currRow - start);
                currCol = currCol + points[j][1] * diff;
                currRow = currRow + points[j][0] * diff;
                if (currCol == end && (currRow == start || currRow == end))
                    j++;
                else if (currRow == end && currCol == start)
                    j++;
                k = k - diff;
            }
            int currTemp = matrix[currRow][currCol];
            matrix[currRow][currCol] = temp;
            temp = currTemp;
        }
        matrix[row][col] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        new RotateImage().rotate(matrix);
    }

    public void rotateWithExtraSpace(int[][] matrix) {
        int[][] copyMatrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                copyMatrix[j][matrix.length - 1 - i] = matrix[i][j];
            }
        }
        for (int i = 0; i < copyMatrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = copyMatrix[i][j];
            }
        }

    }

    public void rotateWithTransposeAndReverse(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }

    }
}
