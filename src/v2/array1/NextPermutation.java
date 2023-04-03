package v2.array1;

import v2.util.PrintHelper;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        int last = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < last) {
                swap(i, findJustBigPos(i, nums), nums);
                reverse(i + 1, nums);
                return;
            }
            last = nums[i];
        }
        reverse(0, nums);
    }

    private void reverse(int startPos, int[] nums) {
        for (int i = 0; i < (nums.length - startPos) / 2; i++) {
            swap(startPos + i, nums.length - 1 - i, nums);
        }
    }

    private void swap(int pos1, int pos2, int[] nums) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    private int findJustBigPos(int swapPos, int[] nums) {
        int startPos = swapPos + 2;
        int currentCandidatePos = swapPos + 1;
        for (int i = startPos; i < nums.length; i++) {
            if (nums[i] > nums[swapPos] && nums[i] < nums[currentCandidatePos])
                currentCandidatePos = i;
        }
        return currentCandidatePos;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 6, 7, 8};

        new NextPermutation().reverse(1, nums);
        PrintHelper.printArray(nums);
    }
}
