package v2.myPractice;

import java.util.ArrayDeque;
import java.util.Queue;

public class MinPath {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 0 && j == 0) {
                    grid[i][j] = 0;
                } else if (i == 0) {
                    grid[0][j] += grid[0][j - 1];
                } else if (j == 0) {
                    grid[i][0] += grid[i - 1][0];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[rows - 1][columns - 1];
    }

    public int minPathSum2(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int[][] cost = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        Pair start = new Pair(rows - 1, columns - 1);
        Queue<Pair> queue = new ArrayDeque<>(rows * columns);
        queue.add(start);
        cost[start.x][start.y] = grid[start.x][start.y];
        while (!queue.isEmpty()) {
            Pair current = queue.remove();
            int newX = current.x - 1;
            int newY = current.y;
            if (newX > -1 && newY > -1) {
                cost[newX][newY] = Math.min(cost[newX][newY], cost[current.x][current.y] + grid[newX][newY]);
                queue.add(new Pair(newX, newY));
            }
            newX = current.x;
            newY = current.y - 1;
            if (newX > -1 && newY > -1) {
                cost[newX][newY] = Math.min(cost[newX][newY], cost[current.x][current.y] + grid[newX][newY]);
                queue.add(new Pair(newX, newY));
            }
        }
        return cost[0][0];
    }

    public int minPathSumRes(int[][] grid, int x, int y, int currentSum) {
        if (x == grid.length || y == grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return currentSum + grid[x][y];
        }
        int sum1 = minPathSumRes(grid, x + 1, y, currentSum + grid[x][y]);
        int sum2 = Integer.MAX_VALUE;
        if (currentSum + grid[x][y] < sum1)
            sum2 = minPathSumRes(grid, x, y + 1, currentSum + grid[x][y]);
        return Math.min(sum1, sum2);

    }

}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
