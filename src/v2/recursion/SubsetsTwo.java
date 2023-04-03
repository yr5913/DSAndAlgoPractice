package v2.recursion;

import java.util.*;

public class SubsetsTwo {
    public List<List<Integer>> subsetsWithDupFirst(int[] nums) {
        Arrays.sort(nums);
        return subsetsWithDupRec(nums, nums.length).stream().toList();
    }

    public Set<List<Integer>> subsetsWithDupRec(int[] nums, int n) {
        if (n == 0) {
            Set<List<Integer>> set = new HashSet<>();
            set.add(new ArrayList<>());
            return set;
        }
        Set<List<Integer>> set = subsetsWithDupRec(nums, n - 1);
        int curr = nums[n - 1];
        Set<List<Integer>> tempSet = new HashSet<>();
        for (List<Integer> list : set) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(curr);
            tempSet.add(newList);
        }
        set.addAll(tempSet);
        return set;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        return null;
    }

}
