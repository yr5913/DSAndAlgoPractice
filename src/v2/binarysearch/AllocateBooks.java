package v2.binarysearch;

public class AllocateBooks {

    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        int[] arr = time;
        int x = m;
        if (x > arr.length) {
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = 0;
        for (int i = 0; i < arr.length; i++) {
            low = Math.min(low, arr[i]);
            high += arr[i];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int index = 0;
            int sum = 0;
            int counter = 0;
            while (index != arr.length) {
                if (sum + arr[index] > mid) {
                    if (arr[index] > mid) {
                        counter = x;
                        break;
                    }
                    sum = arr[index++];
                    counter++;
                } else {
                    sum += arr[index++];
                }
            }
            if (counter > x - 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static long ayushGivesNinjatestRec(int n, int m, int[] time) {
        return allocateRec(0, 0, m, time, 0, Integer.MIN_VALUE);
    }

    public static int allocateRec(int index, int counter, int m, int[] time, int sum, int prevSum) {
        if (index == time.length) {
            if (counter == m - 1)
                return Math.max(prevSum, sum);
            else
                return Integer.MAX_VALUE;
        }
        int val = allocateRec(index + 1, counter, m, time, sum + time[index], prevSum);
        int val2 = Integer.MAX_VALUE;
        if (sum != 0) {
            val2 = allocateRec(index + 1, counter + 1, m, time, time[index], Math.max(sum, prevSum));
        }
        return Math.min(val, val2);
    }

    public static void main(String[] args) {
        int[] time = { 53, 77, 8, 28, 33, 98, 81, 35, 13, 65, 14, 63, 36, 25, 69};
        System.out.println(ayushGivesNinjatest(5, 12, time));
        System.out.println(ayushGivesNinjatestRec(5, 26, time));
    }
}
