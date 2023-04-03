package v2.myPractice;

public class RemoveDuplicates {


    public int removeDuplicates(int[] nums) {
        int swapFactor = 0;
        int prevElement = nums[0];
        int count = 1;
        int ret = 1;
        for (int i = 1; i < nums.length; i++) {
            if (prevElement == nums[i]) {
                count++;
            } else {
                count = 1;
            }
            prevElement = nums[i];
            if (count < 3) {
                ret++;
                nums[i - swapFactor] = nums[i];
            } else {
                swapFactor++;
            }
        }
        return ret;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 2, 2, 3, 3};
        new RemoveDuplicates().removeDuplicates(nums);
    }
}
