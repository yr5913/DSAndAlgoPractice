package v2.myPractice;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        return uniquePathsRec(obstacleGrid, 0, 0);
    }

    public int uniquePathsRec(int[][] obstacleGrid, int x, int y) {
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            return 1;
        }
        if (x == obstacleGrid.length || y == obstacleGrid[0].length) {
            return 0;
        }
        if (obstacleGrid[x][y] == 1) {
            return 0;
        }
        if (obstacleGrid[x][y] > 1) {
            return obstacleGrid[x][y] - 2;
        }
        int count1 = uniquePathsRec(obstacleGrid, x + 1, y);
        int count2 = uniquePathsRec(obstacleGrid, x, y + 1);
        int total = count1 + count2;
        obstacleGrid[x][y] = count1 + count2 + 2;
        return total;

    }
}
