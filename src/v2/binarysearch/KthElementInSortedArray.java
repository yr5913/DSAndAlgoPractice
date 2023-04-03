package v2.binarysearch;

public class KthElementInSortedArray {

    public long kthElement(int arr1[], int arr2[], int n, int m, int k) {
        int[] minArray = arr1;
        int[] maxArray = arr2;
        if (arr2.length < arr1.length) {
            minArray = arr2;
            maxArray = arr1;
        }
        int low = 0;
        int high = minArray.length;
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;
            if (cut2 < 0) {
                high = cut1 - 1;
            } else if (cut2 > maxArray.length) {
                low = cut1 + 1;
            } else {
                int l1 = cut1 == 0 ? Integer.MIN_VALUE : minArray[cut1 - 1];
                int l2 = cut2 == 0 ? Integer.MIN_VALUE : maxArray[cut2 - 1];
                int r1 = cut1 == minArray.length ? Integer.MAX_VALUE : minArray[cut1];
                int r2 = cut2 == maxArray.length ? Integer.MAX_VALUE : maxArray[cut2];
                if (l1 > r2) {
                    high = cut1 - 1;
                } else if (l2 > r1) {
                    low = cut1 + 1;
                } else {
                    return Math.max(l1, l2);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] x = {1, 5, 6, 9, 10};
        int[] y = {0, 3, 15};
        System.out.println(new KthElementInSortedArray().kthElement(x, y, x.length, y.length, 1));
    }
}
