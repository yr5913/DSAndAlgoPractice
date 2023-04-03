package v2.stackandqueue2;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    count++;
                    if (grid[i][j] == 2) {
                        queue.add(new int[]{i, j});
                    } else {
                        fresh++;
                    }
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        if (queue.size() == 0) {
            return -1;
        }
        int totalRot = 0;
        int time = 0;
        while (!queue.isEmpty()) {
            totalRot += queue.size();
            int currSize = queue.size();
            for (int i = 0; i < currSize; i++) {
                int[] current = queue.remove();
                int[] xDi = {1, -1, 0, 0};
                int[] yDi = {0, 0, 1, -1};
                for (int j = 0; j < xDi.length; j++) {
                    if (canBeVisited(current[0] + xDi[j], current[1] + yDi[j], grid)) {
                        grid[current[0]][current[1]] = 2;
                        queue.add(new int[]{current[0] + xDi[j], current[1] + yDi[j]});
                    }

                }
            }
            if (queue.size() > 0) {
                time++;
            }

        }
        return totalRot == count ? time : -1;
    }

    private boolean canBeVisited(int x, int y, int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
            return false;
        }
        return true;
    }


    public int orangesRottingOld(int[][] grid) {
        int[] times = new int[grid.length * grid[0].length];
        Set<Integer> unvisited = new HashSet<>();
        int oranges = 0;
        int freshOranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    oranges++;
                    if (grid[i][j] == 2) {
                        unvisited.add(i * grid[i].length + j);
                    } else {
                        freshOranges++;
                    }
                }
            }
        }
        if (unvisited.size() == 0) {
            return -1;
        }
        if ((unvisited.size() == oranges)) {
            return 0;
        }
        while (!unvisited.isEmpty()) {

            Set<Integer> visited = new HashSet<>();
            Queue<Pair> queue = new ArrayDeque<>(grid.length * grid[0].length);
            int value = unvisited.stream().findAny().get();
            queue.add(new Pair(value, 0));
            unvisited.remove(value);
            int[] xDi = {1, -1, 0, 0};
            int[] yDi = {0, 0, 1, -1};
            while (!queue.isEmpty()) {
                Pair pair = queue.remove();
                int current = pair.value;
                int time = pair.time;
                int x = current / grid[0].length;
                int y = current % grid[0].length;
                visited.add(current);
                times[current] = time;
                for (int i = 0; i < xDi.length; i++) {
                    int x2 = x + xDi[i];
                    int y2 = y + yDi[i];
                    int val = isCheck(x2, y2, times, grid, visited, time + 1);
                    if (val != -1)
                        queue.add(new Pair(val, time + 1));
                }

            }
        }
        int max = 0;
        int newRotten = 0;
        for (int i = 0; i < times.length; i++) {
            if (times[i] > 0) {
                newRotten++;
                max = Math.max(times[i], max);
            }
        }
        if (newRotten == freshOranges)
            return max;
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        new RottenOranges().orangesRotting(arr);
    }


    private int isCheck(int x, int y, int[] arr, int[][] grid, Set<Integer> visited, int time) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return -1;
        }
        if (grid[x][y] != 1) {
            return -1;
        }
        int index = x * grid[0].length + y;
        if (visited.contains(index)) {
            return -1;
        }
        if (arr[index] != 0 && arr[index] <= time) {
            return -1;
        }
        return index;
    }


}

class Pair {
    int value;
    int time;

    public Pair(int value, int time) {
        this.value = value;
        this.time = time;
    }
}
