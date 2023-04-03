package v2.array2;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            int numberAtIndex = nums[index];
            if (numberAtIndex < 0)
                return index;
            nums[index] *= -1;
        }
        return 0;
    }

}
