package v2.Recursion2;

import java.util.ArrayList;
import java.util.List;

public class Permutations {


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        permuteRec(nums, 0, ansList);
        return ansList;
    }

    public void permuteRec(int[] nums, int index, List<List<Integer>> ansList) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            ansList.add(list);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permuteRec(nums, index + 1, ansList);
            swap(nums, index, i);
        }
    }

    public List<List<Integer>> permuteRecTwo(int[] nums, int index) {
        if (index == nums.length) {
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>());
            return list;
        }
        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            List<List<Integer>> list = permuteRecTwo(nums, index + 1);
            for (List<Integer> inner : list) {
                inner.add(nums[index]);
            }
            returnList.addAll(list);
            swap(nums, index, i);
        }
        return returnList;
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(new Permutations().permute(arr));
    }
}
