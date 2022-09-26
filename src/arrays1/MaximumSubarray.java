package arrays1;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            if(sum<nums[i])
                sum = nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public int maxSubArrayDivideAndConquer(int[] nums) {
        return maxSubSplit(nums, 0, nums.length-1)[0];
    }

    public int[] maxSubSplit(int[] nums, int start, int end){
        if(start==end) {
            int[] array = new int[4];
            for(int i=0;i<array.length;i++){
                array[i] = nums[start];
            }
            return array;
        }
        int mid = (start+ end)/2;

        int[] larray = maxSubSplit(nums, start, mid);
        int[] rarray = maxSubSplit(nums, mid+1, end);
        int[] newArray = new int[4];
        newArray[0] = Math.max(Math.max(larray[0], rarray[0]),larray[2]+ rarray[1]);
        newArray[1]= Math.max(larray[3]+rarray[1], larray[1]);
        newArray[2] = Math.max(rarray[3]+larray[2], rarray[2]);
        newArray[3] = larray[3]+rarray[3];
        return newArray;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        new MaximumSubarray().maxSubArray(arr);
    }
}
