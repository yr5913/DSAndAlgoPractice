package v2.myPractice;

public class SpiralOrder2 {

    public int[][] generateMatrix(int n) {
        int x = 0;
        int y = 0;
        int lowerBound = 0;
        int upperBoundX = n;
        int upperBoundY = n;
        int total = n * n;
        int count = 0;
        int loop = 0;
        int[][] matrix = new int[n][n];
        while (true) {
            if (count == total) {
                break;
            }
            if (loop == 0) {
                while (y < upperBoundY) {
                    matrix[x][y++] = ++count;
                }
                y--;
                x++;
            } else if (loop == 1) {
                while (x < upperBoundX) {
                    matrix[x++][y] = ++count;
                }
                x--;
                y--;
            } else if (loop == 2) {
                while (y >= lowerBound) {
                    matrix[x][y--] = ++count;
                }
                y++;
                x--;
            } else {
                lowerBound++;
                upperBoundY--;
                upperBoundX--;
                while (x >= lowerBound) {
                    matrix[x--][y] = ++count;
                }
                x++;
                y++;
                loop = -1;
            }
            loop++;
        }
        return matrix;
    }
}
