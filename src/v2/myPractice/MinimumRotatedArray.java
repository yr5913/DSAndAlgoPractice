package v2.myPractice;

public class MinimumRotatedArray {


    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low];

    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3 };
        System.out.println(new MinimumRotatedArray().findMin(arr));
    }
}
