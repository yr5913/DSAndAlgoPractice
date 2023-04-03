package v2.myPractice;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
              if (map.containsKey(numbers[i])) {
                ans[0] = map.get(numbers[i]) + 1;
                ans[1] = i + 1;
                break;
            }
            map.put(target - numbers[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,7, 11, 15};
        new TwoSum().twoSum(arr, 9);
    }
}
