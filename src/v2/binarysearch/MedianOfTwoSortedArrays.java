package v2.binarysearch;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArraysOne(int[] nums1, int[] nums2) {
        int start1 = 0;
        int start2 = 0;
        int len = nums1.length + nums2.length;

        int index2 = len / 2;
        int index1 = index2 - 1;
        int current = 0;
        int[] arr = new int[2];
        int arrIndex = 0;
        while (start1 < nums1.length && start2 < nums2.length) {
            int currentNum;
            if (nums1[start1] > nums2[start2]) {
                currentNum = nums2[start2++];

            } else {
                currentNum = nums1[start1++];
            }
            if (current == index1) {
                arr[arrIndex++] = currentNum;
            } else if (current == index2) {
                arr[arrIndex++] = currentNum;
            }
            current++;
        }
        while (start1 < nums1.length) {
            if (current == index1) {
                arr[arrIndex++] = nums1[start1];
            } else if (current == index2) {
                arr[arrIndex++] = nums1[start1];
            }
            start1++;
            current++;
        }
        while (start2 < nums2.length) {
            if (current == index1) {
                arr[arrIndex++] = nums2[start2];
            } else if (current == index2) {
                arr[arrIndex++] = nums2[start2];
            }
            start2++;
            current++;
        }
        if (len % 2 == 0) {
            return (arr[0] + arr[1]) / 2.0;
        }
        return arr[1];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] minArray = nums1;
        int[] maxArray = nums2;
        if (nums2.length < nums1.length) {
            minArray = nums2;
            maxArray = nums1;
        }
        int leftElements = (nums1.length + nums2.length) / 2;
        if (leftElements == 0) {
            if (nums1.length == 0) {
                return nums2[0];
            } else
                return nums1[0];
        }
        int start = 0;
        int end = minArray.length;
        while (start <= end) {
            int cutMin = (start + end) / 2;
            int cutMax = leftElements - cutMin;
            int valid = checkValidCut(minArray, maxArray, cutMin, cutMax);
            if (valid == 0) {
                double median1 = getMedian(minArray, maxArray, cutMin, cutMax, true);
                if ((nums1.length + nums2.length) % 2 == 0) {
                    return (getMedian(minArray, maxArray, cutMin - 1, cutMax - 1, false) + median1) / 2;
                } else {
                    return median1;
                }
            } else if (valid > 0) {
                end = cutMin - 1;
            } else {
                start = cutMin + 1;
            }
        }
        return 0;
    }

    public double getMedian(int[] nums1, int[] nums2, int cut1, int cut2, boolean isMin) {
        double median1 = 0;
        if (cut1 < 0 || cut1 >= nums1.length) {
            median1 = nums2[cut2];
        } else if (cut2 < 0 || cut2 >= nums2.length) {
            median1 = nums1[cut1];
        } else {
            if (isMin)
                median1 = Math.min(nums1[cut1], nums2[cut2]);
            else
                median1 = Math.max(nums1[cut1], nums2[cut2]);
        }
        return median1;
    }

    public int checkValidCut(int[] nums1, int[] nums2, int cut1, int cut2) {
        int left1 = cut1 - 1;
        int left2 = cut2 - 1;
        if (left1 > -1 && left1 < nums1.length && cut2 > -1 && cut2 < nums2.length && nums1[left1] > nums2[cut2]) {
            return 1;
        } else if (left2 > -1 && left2 < nums2.length && cut1 > -1 && cut1 < nums1.length && nums2[left2] > nums1[cut1]) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arrq = {3};
        int[] arr2 = {-2, -1};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(arrq, arr2));
    }
}
