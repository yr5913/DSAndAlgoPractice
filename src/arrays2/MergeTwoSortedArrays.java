package arrays2;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int k = 0;
        int j = 0;
        while (j < nums2.length && k < m) {
            if (nums1[i] > nums2[j]) {
                shiftElements(nums1, i, nums2[j], m + j);
                j++;
            } else {
                k++;
            }
            i++;
        }
        while (j < nums2.length) {
            nums1[m + j] = nums2[j];
            j++;
        }
    }

    public void mergeWithExtraSpace(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] nums3 = new int[nums1.length];
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                nums3[k++] = nums2[j++];
            } else
                nums3[k++] = nums1[i++];
        }
        while (i < m) {
            nums3[k++] = nums1[i++];
        }
        while (j < n) {
            nums3[k++] = nums2[j++];
        }
        for (i = 0; i < nums1.length; i++) {
            nums1[i] = nums3[i];
        }
    }

    public void mergeWithDiffminton(int[] nums1, int m, int[] nums2, int n) {
        if (n > 0) {
            for (int i = 0; i < m; i++) {
                if (nums1[i] > nums2[0]) {
                    int temp = nums1[i];
                    nums1[i] = nums2[0];
                    nums2[0] = temp;
                    Arrays.sort(nums2);
                }
            }
            for (int i = 0; i < n; i++) {
                nums1[i + m] = nums2[i];
            }
        }
    }

    public void mergeWithMPlusN(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int current = m + n - 1;
        while (right >= 0) {
            if (left < 0)
                nums1[current--] = nums2[right--];
            else if (nums1[left] > nums2[right]) {
                nums1[current--] = nums1[left--];
            } else
                nums1[current--] = nums2[right--];
        }
    }

    private void shiftElements(int[] nums1, int start, int temp, int end) {
        for (int i = end; i > start; i--) {
            nums1[i] = nums1[i - 1];
        }
        nums1[start] = temp;
    }


    public static void main(String[] args) {
        new MergeTwoSortedArrays().merge(new int[]{2, 0}, 1, new int[]{1}, 1);
    }
}
