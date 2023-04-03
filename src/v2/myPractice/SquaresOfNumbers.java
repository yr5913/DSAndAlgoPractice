package v2.myPractice;

public class SquaresOfNumbers {

    public int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];
        if (nums[0] > -1) {
            for (int i = 0; i < nums.length; i++) {
                squares[i] = nums[i] * nums[i];
            }
        } else if (nums[nums.length - 1] < 0) {
            for (int i = 0; i < nums.length; i++) {
                squares[nums.length - i - 1] = nums[i] * nums[i];
            }
        } else {
            int startPos = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > -1) {
                    startPos = i;
                    break;
                }
            }
            int k = 0;
            int left = startPos - 1;
            int right = startPos;
            while (left > -1 && right < nums.length) {
                if (nums[left] * nums[left] < nums[right] * nums[right]) {
                    squares[k++] = nums[left] * nums[left];
                    left--;
                } else {
                    squares[k++] = nums[right] * nums[right];
                    right++;
                }
            }
            for (int i = left; i > -1; i--) {
                squares[k++] = nums[left] * nums[left];
            }
            for (int i = right; i < nums.length; i++) {
                squares[k++] = nums[right] * nums[right];
            }
        }
        return squares;
    }
}
