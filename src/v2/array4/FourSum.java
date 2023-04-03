package v2.array4;

import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> returnList = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int newTarget = target - nums[i] - nums[j];
                Map<Integer, Integer> map = new HashMap<>();
                for (int k = j + 1; k < nums.length; k++) {
                    if (map.containsKey(nums[k])) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(newTarget - nums[k]);
                        list.add(nums[k]);
                        list.sort(Comparator.comparingInt(n -> n));
                        returnList.add(list);
                    } else {
                        map.put(newTarget - nums[k], k);
                    }
                }
            }
        }
        return returnList.stream().toList();
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        System.out.println(new FourSum().fourSum(nums, 8));
    }
}
