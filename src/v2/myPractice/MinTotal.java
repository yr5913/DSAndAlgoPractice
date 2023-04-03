package v2.myPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinTotal {


    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] memory = new int[(size * (size + 1)) / 2];
        boolean[] visited = new boolean[memory.length];
        return minimumTotal(triangle, 0, 0, memory, visited);
    }


    public int minimumTotal(List<List<Integer>> triangle, int row, int column, int[] memory, boolean[] visited) {
        if (row == triangle.size()) {
            return 0;
        }
        int val = row * (row + 1) / 2 + column;

        if (visited[val]) {
            return memory[val];
        }
        memory[val] = triangle.get(row).get(column) + Math.min(minimumTotal(triangle, row + 1, column, memory, visited), minimumTotal(triangle, row + 1, column + 1, memory, visited));
        visited[val] = true;
        return memory[val];
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 4));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(6, 5, 7));
        List<Integer> list4 = new ArrayList<>(Arrays.asList(4, 1, 8, 3));

        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(new MinTotal().minimumTotal(list));
    }
}
