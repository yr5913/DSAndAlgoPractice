package v2.array4;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        Set<Integer> integersCopy = new HashSet<>();
        for (int num : nums) {
            integers.add(num);
        }
        int maxCount = 0;
        for (Integer integer : integers) {
            if (!integersCopy.contains(integer)) {
                int count = 1;
                int i = integer;
                while (integers.contains(--i)) {
                    count++;
                    integersCopy.add(i);
                }
                i = integer;
                while (integers.contains(++i)) {
                    count++;
                    integersCopy.add(i);
                }
                integersCopy.add(integer);

                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }

}
