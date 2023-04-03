package v2.binarysearch;

public class SingleElementInSortedArray {

    public String reverseWords(String s) {
        String[] stringArray = s.strip().split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(stringArray[stringArray.length - 1]);
        for (int i = stringArray.length - 2; i >= 0; i--) {
            sb.append(" ");
            sb.append(stringArray[i]);
        }
        return sb.toString();
    }

    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int j = 0;
            int k = image.length - 1;
            while (j < k) {
                int temp = (image[i][j] == 1 ? 0 : 1);
                image[i][j++] = (image[i][k] == 1 ? 0 : 1);
                image[i][k--] = temp;
            }
        }
        return image;
    }

    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid % 2 == 0) {
                if (nums[mid + 1] == nums[mid]) {
                    start = mid + 2;
                } else if (nums[mid - 1] == nums[mid]) {
                    end = mid - 2;
                } else {
                    return nums[mid];
                }
            } else {
                if (nums[mid - 1] == nums[mid]) {
                    start = mid + 1;
                } else if (nums[mid + 1] == nums[mid]) {
                    end = mid - 1;
                } else {
                    return nums[mid];
                }
            }
        }
        return nums[start];
    }
}
