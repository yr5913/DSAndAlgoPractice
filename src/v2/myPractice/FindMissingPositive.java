package v2.myPractice;

public class FindMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        long expectedSum = 0;
        for (int i = min; i <= max; i++) {
            expectedSum += i;
        }
        return (int) (expectedSum - sum);
    }
}
