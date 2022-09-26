package arrays1;

public class NextPermutation {
    /**
     * https://leetcode.com/problems/next-permutation/
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2; i > -1; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    reverse(nums, i + 1, nums.length - 1);
                    return;
                }
            }
        }
        swap(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void nextPermutationOptimumSolution(int[] nums) {
        int last = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < last) {
                int justIndex = nums.length - 1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] >= nums[j]) {
                        justIndex = j - 1;
                        break;
                    }
                }
                swap(nums, i, justIndex);
                reverse(nums, i + 1, nums.length - 1);
                return;
            }
            last = nums[i];
        }
        reverse(nums, 0, nums.length - 1);

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        new NextPermutation().nextPermutationOptimumSolution(nums);
        System.out.println(nums);
    }
}
