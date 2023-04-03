package v2.myPractice;

public class MoveArray {

    public int[] sortArrayByParity(int[] nums) {
        int front = 0;
        int back = nums.length - 1;
        int[] retArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                retArray[front++] = nums[i];
            } else {
                retArray[back--] = nums[i];
            }
        }
        return retArray;
    }
}
