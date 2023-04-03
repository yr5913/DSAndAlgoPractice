package v2.heaps;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<Integer>((i1, i2) -> i2 - i1);
        for (int num : nums) {
            queue.add(num);
        }
        int kth = 0;
        for (int i = 0; i < k; i++) {
            kth = queue.remove();
        }
        return kth;
    }


}
