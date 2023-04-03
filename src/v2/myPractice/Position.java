package v2.myPractice;

import java.util.Arrays;

public class Position {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (start == nums.length || nums[start] != target)
            return ans;
        ans[0] = start;
        end = nums.length - 1;
        start++;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else
                start = mid + 1;

        }
        ans[1] = end;
        return ans;
    }

    public int[] searchRange2(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                int index = mid + 1;
                while (index < nums.length) {
                    if (nums[index] != target) {
                        break;
                    }
                    index++;
                }
                ans[1] = index - 1;

                index = mid - 1;
                while (index > -1) {
                    if (nums[index] != target) {
                        break;
                    }
                    index--;
                }
                ans[0] = index + 1;
                break;

            } else if (nums[mid] > target) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Position().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5)));
    }
}
