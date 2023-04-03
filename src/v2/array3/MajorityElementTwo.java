package v2.array3;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementTwo {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> integers = new ArrayList<>();
        int num1 = Integer.MIN_VALUE;
        int num2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (num1 == nums[i]) {
                count1++;
            } else if (num2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (
                int i = 0;
                i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            integers.add(num1);
        }
        if (count2 > nums.length / 3) {
            integers.add(num2);
        }
        return integers;
    }

    public static void main(String[] args) {
        int[] array = {2, 1, 1, 3, 1, 4, 5, 6};
        new MajorityElementTwo().majorityElement(array);
    }
}
