package arrays2;

import java.util.*;

public class MergeIntervals {
    /**
     * https://leetcode.com/problems/merge-intervals/solution/
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        HashSet<int[]> arrayList = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            boolean ignore = false;
            if (set.contains(i))
                continue;
            for (int j = 0; j < intervals.length; j++) {
                if (i != j)
                    if ((start <= intervals[j][0] && end >= intervals[j][0]) || (start <= intervals[j][1] && end >= intervals[j][1]) || (end >= intervals[j][0] && end <= intervals[j][1]) || (start >= intervals[j][0] && start <= intervals[j][1])) {
                        if (set.contains(j)) {
                            ignore = true;
                            break;
                        }
                        start = Math.min(start, intervals[j][0]);
                        end = Math.max(end, intervals[j][1]);
                        set.add(j);
                    }
            }
            if (ignore)
                continue;
            set.add(i);
            int[] current = new int[2];
            current[0] = start;
            current[1] = end;
            arrayList.add(current);
        }
        int[][] list = new int[arrayList.size()][2];
        arrayList.toArray(list);
        return list;
    }

    public int[][] mergeOptimum(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= start && intervals[i][0] <= end) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            } else {
                int[] add = new int[2];
                add[0] = start;
                add[1] = end;
                list.add(add);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        int[] add = new int[2];
        add[0] = start;
        add[1] = end;
        list.add(add);
        int[][] listFinal = new int[list.size()][2];
        list.toArray(listFinal);
        return listFinal;
    }

    public static void main(String[] args) {
        int[][] arrays = {{2, 3}, {4, 6}, {5, 7}, {3, 4}};
        new MergeIntervals().merge(arrays);
    }
}
