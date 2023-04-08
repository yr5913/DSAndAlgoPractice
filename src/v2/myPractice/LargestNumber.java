package v2.myPractice;

import java.util.Arrays;

public class LargestNumber {

    public String largestNumber(int[] nums) {

        String[] strings = new String[nums.length];
        int endIndex = 0;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            strings[endIndex++] = String.valueOf(nums[i]);
        }
        if (zeroCount == nums.length) {
            return "0";
        }

        Arrays.sort(strings, 0, endIndex, (s1, s2) -> {
            int val = 0;
            String max = s1;
            String min = s2;
            if (s1.length() < s2.length()) {
                max = s2;
                min = s1;
            }
            int index1 = 0;
            int index2 = 0;
            while (index1 < max.length()) {
                if (index2 == min.length()) {
                    index2 = 0;
                }
                val = max.charAt(index1++) - min.charAt(index2++);
                if (val != 0)
                    break;
            }
            if (val == 0) {
                index1 = 0;
                while (index2 < min.length()) {
                    val = max.charAt(index1++) - min.charAt(index2++);
                    if (val != 0)
                        break;
                }
            }

            return max == s2 ? val : val * -1;
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{432, 43243}));
    }
}
