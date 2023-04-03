package v2.array3;

import java.util.Arrays;

public class ReversePairs {
    private int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums);
        return count;
    }

    public int[] mergeSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int[] leftArray = Arrays.copyOfRange(nums, 0, nums.length / 2);
        int[] rightArray = Arrays.copyOfRange(nums, nums.length / 2, nums.length);
        int[] leftSorted = mergeSort(leftArray);
        int[] rightSorted = mergeSort(rightArray);
        return merge(leftSorted, rightSorted);
    }

    public int[] merge(int[] leftArray, int[] rightArray) {

        int[] merged = new int[leftArray.length + rightArray.length];
        int j = 0;
        for (int i = 0; i < leftArray.length; i++) {
            while (j < rightArray.length && (long)leftArray[i] > (long)2 * rightArray[j]) {
                j++;
            }
            count += (j);
        }
        int i = 0;
        j = 0;
        int k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                merged[k++] = leftArray[i++];
            } else {
                merged[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length) {
            merged[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            merged[k++] = rightArray[j++];
        }
        return merged;
    }

}
