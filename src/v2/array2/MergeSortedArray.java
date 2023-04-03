package v2.array2;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int currIndex = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (currIndex > -1) {
            if (m < 0)
                nums1[currIndex--] = nums2[n--];
            else if (n < 0)
                currIndex--;
            else if (nums1[m] > nums2[n]) {
                nums1[currIndex--] = nums1[m--];
            } else
                nums1[currIndex--] = nums2[n--];
        }
    }
}
