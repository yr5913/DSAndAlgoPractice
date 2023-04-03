package v2.heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KMostFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer integer : map.keySet()) {
            if (priorityQueue.size() < k) {
                int[] element = new int[2];
                element[0] = integer;
                element[1] = map.get(integer);
                priorityQueue.add(element);
                continue;
            }
            if (priorityQueue.peek()[1] < map.get(integer)) {

                priorityQueue.remove();
                int[] element = new int[2];
                element[0] = integer;
                element[1] = map.get(integer);
                priorityQueue.add(element);
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = priorityQueue.remove()[0];
        }
        return ans;
    }
}
