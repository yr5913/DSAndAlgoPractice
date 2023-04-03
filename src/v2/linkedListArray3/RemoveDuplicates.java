package v2.linkedListArray3;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int slow = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                if (slow == nums.length) {
                    slow = i;
                }
            } else {
                if (slow != nums.length) {
                    nums[slow++] = nums[i];
                }
            }
        }
        return slow;
    }
}
