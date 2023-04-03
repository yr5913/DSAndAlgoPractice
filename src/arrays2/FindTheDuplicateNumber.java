package arrays2;

public class FindTheDuplicateNumber {
    /**
     * https://leetcode.com/problems/find-the-duplicate-number/solution/
     * @param nums
     * @return
     */

    public int findDuplicate(int[] nums) {

        int[] countArray = new int[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (countArray[nums[i] - 1] == 1)
                return nums[i];
            countArray[nums[i] - 1]++;
        }
        return 0;

    }

    public int findDuplicateBest(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val] < 0)
                return val;
            nums[val]*=-1;
        }
        return 0;

    }

//    public int findDuplicateShravaniSumSolution(int[] nums){
//        int n = nums.length-1;
//        int sum = n * (n+1) /2;
//        for(int i=0;i<nums.length;i++){
//            sum-=nums[i];
//        }
//        return -1 * sum;
//    }
}
