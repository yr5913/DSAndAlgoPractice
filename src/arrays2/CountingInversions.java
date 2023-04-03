package arrays2;

public class CountingInversions {

    static long count = 0;

    public static long getInversions(long arr[], int n) {
        // Write your code here.
        mergeSort(arr);
        return count;
    }

    public static long[] mergeSort(long arr[]) {
        if (arr.length < 2)
            return arr;
        int mid = arr.length / 2;
        long[] leftArray = new long[mid];
        for (int i = 0; i < mid; i++) {
            leftArray[i] = arr[i];
        }
        long[] rightArray = new long[arr.length - mid];
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = arr[mid + i];
        }
        long[] leftSortedArray = mergeSort(leftArray);
        long[] rightSortedArray = mergeSort(rightArray);
        return merge(leftSortedArray, rightSortedArray);
    }

    public static long[] merge(long[] leftArray, long[] rightArray) {
        long[] sortedCombinedArray = new long[leftArray.length + rightArray.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] > rightArray[j]) {
                count = count + (leftArray.length - i);
                sortedCombinedArray[k++] = rightArray[j++];
            } else
                sortedCombinedArray[k++] = leftArray[i++];
        }
        while (i < leftArray.length)
            sortedCombinedArray[k++] = leftArray[i++];
        while (j < rightArray.length)
            sortedCombinedArray[k++] = rightArray[j++];
        return sortedCombinedArray;
    }

    public static long getInversionsBrute(long arr[], int n) {
        // Write your code here.
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++)
                if (arr[i] > arr[j])
                    count++;
        }
        return count;
    }
}
