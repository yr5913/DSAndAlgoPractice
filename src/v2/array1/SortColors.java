package v2.array1;

public class SortColors {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = nums.length - 1;
        while (one < two) {
            if (nums[one] == 2) {
                swap(one, two, nums);
                two--;
            } else if (nums[one] == 0) {
                swap(zero, one, nums);
                one++;
                zero++;
            } else {
                one++;
            }
        }
    }

    private void swap(int pos1, int pos2, int[] nums) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }
}
