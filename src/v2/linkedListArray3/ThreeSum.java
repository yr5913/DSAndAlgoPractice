package v2.linkedListArray3;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> listSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            int target = 0 - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(nums[j])) {
                    List<Integer> arrayList = new ArrayList<>();
                    arrayList.add(nums[i]);
                    arrayList.add(nums[j]);
                    arrayList.add(target - nums[j]);
                    arrayList.sort(Comparator.comparingInt(integer -> integer));
                    listSet.add(arrayList);
                } else {
                    set.add(target - nums[j]);
                }
            }
        }
        return listSet.stream().toList();
    }
}
