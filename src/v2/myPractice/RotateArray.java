package v2.myPractice;

/**
 * https://leetcode.com/problems/rotate-array/
 * 189. Rotate Array
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {

    /**
     * Solution 2 uses extra space
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        int temp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    /**
     * doesn't use extra scape single pass
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += rotate(nums, i, k);
            if (count == nums.length)
                break;
        }
    }


    /**
     * Optimal solution using reverse
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }


    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }


    public int rotate(int[] nums, int start, int k) {
        int next = nums[start];
        int current = start;
        int count = 0;
        while (true) {
            current += k;
            int temp = nums[current];
            nums[current] = next;
            next = temp;
            count++;
            if (current == start) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        new RotateArray().rotate(new int[]{-1, -100, 3, 99}, 2);
    }
}
