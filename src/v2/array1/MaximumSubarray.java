package v2.array1;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int runningSum = sum;
        for (int i = 1; i < nums.length; i++) {
            if (runningSum < 0 && runningSum <= nums[i]) {
                runningSum = nums[i];
            } else
                runningSum += nums[i];
            if (runningSum > sum)
                sum = runningSum;
        }
        return sum;
    }
}
