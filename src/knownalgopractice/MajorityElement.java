package knownalgopractice;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0)
                nums[i] = candidate;
            if (nums[i] == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }
}
