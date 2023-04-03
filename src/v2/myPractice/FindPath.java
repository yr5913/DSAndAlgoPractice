package v2.myPractice;

public class FindPath {


    public int minPathSum(int[][] grid) {
        return minPathSumRes(grid, 0, 0, 0);
    }

    public int minPathSumRes(int[][] grid, int x, int y, int currentSum) {
        if (x == grid.length || y == grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return currentSum + grid[x][y];
        }
        int sum1 = minPathSumRes(grid, x + 1, y, currentSum + grid[x][y]);
        int sum2 = minPathSumRes(grid, x, y + 1, currentSum + grid[x][y]);
        return Math.min(sum1, sum2);

    }
}
