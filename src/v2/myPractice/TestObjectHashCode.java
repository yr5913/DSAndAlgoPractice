package v2.myPractice;

public class TestObjectHashCode {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(nums.hashCode());
        System.out.println(nums);
        nums[0] = 9;
        System.out.println(nums.hashCode());
        System.out.println(nums);
    }
}
