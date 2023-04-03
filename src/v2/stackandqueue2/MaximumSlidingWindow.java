package v2.stackandqueue2;

import java.util.ArrayDeque;

public class MaximumSlidingWindow {

    public int[] maxSlidingWindowMY(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        ListNode head = null;
        ListNode tail = null;
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {

            while (tail != null && tail.value < nums[i]) {
                if (tail.prev == null) {
                    head = null;
                    tail = null;
                } else {
                    tail = tail.prev;
                    tail.next.prev = null;
                    tail.next = null;
                }
            }
            if (head == null) {
                head = new ListNode(nums[i]);
                head.key = i;
                tail = head;
            } else {
                ListNode listNode = new ListNode(nums[i]);
                tail.next = listNode;
                listNode.prev = tail;
                tail = listNode;
                listNode.key = i;
            }

        }
        ans[0] = head.value;
        for (int i = k; i < nums.length; i++) {
            if (head.key == i - k) {
                head = head.next;
                head.prev.next = null;
                head.prev = null;
            }

            while (tail != null && tail.value < nums[i]) {
                if (tail.prev == null) {
                    head = null;
                    tail = null;
                } else {
                    tail = tail.prev;
                    tail.next.prev = null;
                    tail.next = null;
                }
            }
            if (head == null) {
                head = new ListNode(nums[i]);
                head.key = i;
                tail = head;
            } else {
                ListNode listNode = new ListNode(nums[i]);
                tail.next = listNode;
                listNode.prev = tail;
                tail = listNode;
                listNode.key = i;
            }
            ans[i - k + 1] = head.value;
        }

        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] ans = new int[nums.length - k + 1];
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>(k);
        for (int i = 0; i < k; i++) {
            while (arrayDeque.size() != 0 && nums[arrayDeque.peekLast()] < nums[i]) {
                arrayDeque.removeLast();
            }
            arrayDeque.addLast(i);
        }
        ans[0] = nums[arrayDeque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            if (arrayDeque.peekFirst() == i - k) {
                arrayDeque.removeFirst();
            }
            while (arrayDeque.size() != 0 && nums[arrayDeque.peekLast()] < nums[i]) {
                arrayDeque.removeLast();
            }
            arrayDeque.addLast(i);
            ans[i - k + 1] = nums[arrayDeque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        new MaximumSlidingWindow().maxSlidingWindow(arr, 3);
    }
}

