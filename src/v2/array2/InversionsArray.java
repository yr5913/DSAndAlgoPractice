package v2.array2;

import java.util.Arrays;

public class InversionsArray {
    private static int count = 0;

    public static long getInversions(long arr[], int n) {
        count = 0;
        mergeSort(arr);
        return count;
    }

    public static long[] mergeSort(long[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        long[] splitArray1 = Arrays.copyOfRange(arr, 0, arr.length / 2);
        long[] splitArray2 = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        return merge(mergeSort(splitArray1), mergeSort(splitArray2));
    }

    public static long[] merge(long[] leftArray, long[] rightArray) {
        long[] mergedArray = new long[leftArray.length + rightArray.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (rightArray[j] < leftArray[i]) {
                count += (leftArray.length - i);
                mergedArray[k++] = rightArray[j++];
            } else {
                mergedArray[k++] = leftArray[i++];
            }
        }
        while (i < leftArray.length) {
            mergedArray[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            mergedArray[k++] = rightArray[j++];
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        long [] arr = {2l, 5l, 1l , 3l, 4l};
        InversionsArray.getInversions(arr, 5 );
    }

}
