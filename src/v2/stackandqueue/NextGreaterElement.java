package v2.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                int index = stack.pop();
                ans[index] = nums[i];
            }
            max = Math.max(max, nums[i]);
            stack.push(i);
        }
        if (!stack.isEmpty()) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[stack.peek()] == max) {
                    while (!stack.isEmpty()) {
                        ans[stack.pop()] = -1;
                    }
                }
                while (nums[stack.peek()] < nums[i]) {
                    ans[stack.pop()] = nums[i];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1
        };
        System.out.println(Arrays.toString(new

                NextGreaterElement().

                nextGreaterElements(arr)));
    }
}
