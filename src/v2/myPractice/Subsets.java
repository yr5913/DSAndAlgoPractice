package v2.myPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> set = new ArrayList<>();
        subsets(nums, new ArrayList<>(), set, 0);
        return set;
    }


    public void subsets(int[] nums, List<Integer> list, List<List<Integer>> ans, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        subsets(nums, list, ans, index + 1);
        list.add(nums[index]);
        subsets(nums, list, ans, index + 1);
        list.remove(list.size() - 1);
    }


    public static void main(String[] args) {
        int[] yu = {1,1,3};
        System.out.println(new Subsets().subsets(yu));
    }
}
