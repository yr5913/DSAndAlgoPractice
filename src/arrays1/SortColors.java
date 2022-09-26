package arrays1;

public class SortColors {
    public void sortColors(int[] nums) {
        /**
         * https://leetcode.com/problems/sort-colors/
         */
        int[] colorsCount = new int[3];
        for (int i = 0; i < nums.length; i++) {
            colorsCount[nums[i]]++;
        }
        int j = 0;
        for (int i = 0; i < colorsCount.length; i++) {
            for (int k = 0; k < colorsCount[i]; k++) {
                nums[j++] = i;
            }
        }
    }

    public void sortColorsBetter(int[] nums) {
        int red = 0;
        int white = 0;
        int blue = nums.length - 1;
        while (white < blue) {
            if (nums[white] == 0) {
                swap(nums, white, red);
                white++;
                red++;
            } else if (nums[white] == 1) {
                white++;
            } else {
                swap(nums, white, blue);
                blue--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {2, 0, 2, 1, 1, 0};
        new SortColors().sortColors(arr);
    }

}
