package v2.myPractice;

import java.util.Arrays;

public class MergeIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ans = new int[intervals.length + 1][2];
        int index = 0;
        while (index < intervals.length) {
            if (newInterval[0] < intervals[index][0]) {
                break;
            }
            ans[index] = intervals[index];
            index++;
        }

        int ansIndex = index - 1;
        if (index == 0 || !merge(ans[index - 1], newInterval)) {
            ans[++ansIndex] = newInterval;
        }
        while (index < intervals.length) {
            if (!merge(ans[ansIndex], intervals[index])) {
                ans[++ansIndex] = intervals[index];
            }
            index++;
        }
        return Arrays.copyOf(ans, ansIndex + 1);
    }

    public boolean merge(int[] first, int[] second) {
        if (first[1] < second[0])
            return false;
        first[1] = Math.max(first[1], second[1]);
        return true;
    }

    public static void main(String[] args) {
        new MergeIntervals().insert(new int[][]{{1,3},{6,9}}, new int[]{2,5});
    }
}
