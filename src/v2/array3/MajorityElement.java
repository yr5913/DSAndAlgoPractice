package v2.array3;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElementSol1(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int maxCount = 0;
        int requiredNum = 0;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
            if (count > maxCount) {
                maxCount = count;
                requiredNum = num;
            }
        }
        return requiredNum;
    }


    public int majorityElement(int[] nums) {
        int count = 0;
        int requiredNum = 0;
        for (int num : nums) {
            if (count == 0) {
                count++;
                requiredNum = num;
            } else if (num == requiredNum) {
                count++;
            } else {
                count--;
            }
        }
        return requiredNum;
    }
}
