package v2.myPractice;

public class RotatedArray2 {
    public boolean search(int[] nums, int target) {
        return searchRec(nums, target, 0, nums.length - 1);
    }

    public boolean searchRec(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int val = nums[mid];
            if (val == target) {
                return true;
            }
            int startVal = nums[start];
            int endVal = nums[end];
            if (target == startVal || target == endVal)
                return true;
            if (val == startVal && val == endVal) {
                return searchRec(nums, target, start + 1, mid - 1) || searchRec(nums, target, mid + 1, end - 1);
            }
            if (val == startVal) {
                if (endVal > val && target > endVal) {
                    return false;
                }
                start = mid + 1;
            } else if (val == endVal) {
                if (start < val && target > startVal) {
                    return false;
                }
                end = mid - 1;
            } else if (startVal > val) {
                if (target > startVal || target < val) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (endVal < val) {
                if (target < endVal || target > val) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target > val) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RotatedArray2().search(new int[]{0, 0, 1, 1, 2, 0}, 2));
    }

}
