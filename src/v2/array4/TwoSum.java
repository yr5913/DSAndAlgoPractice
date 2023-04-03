package v2.array4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSumBest(int[] nums, int target) {
        int[] returnArray = new int[2];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (indexMap.containsKey(value)) {
                returnArray[0] = indexMap.get(value);
                returnArray[1] = i;
                return returnArray;
            }
            indexMap.put(nums[i], i);
        }
        return returnArray;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] returnArray = new int[2];
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        int i = 0;
        int j = sorted.length - 1;
        while (i < j) {
            if (sorted[i] + sorted[j] == target) {
                break;
            } else if (sorted[i] + sorted[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        int z=0;
        for (int k=0;k<nums.length;k++){
            if(sorted[i]==nums[k] || sorted[j]==nums[k]){
                returnArray[z++] = k;
            }
        }
        return returnArray;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4};
        new TwoSum().twoSum(nums, 6);
    }
}
