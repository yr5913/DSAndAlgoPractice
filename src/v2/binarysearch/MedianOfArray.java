package v2.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfArray {

    public static int getMedianOne(ArrayList<ArrayList<Integer>> matrix) {
        // Write your code here.
        List<Integer> finalMatrix = matrix.get(0);

        for (int i = 1; i < matrix.size(); i++) {
            finalMatrix = merge(finalMatrix, matrix.get(i));
        }
        return finalMatrix.get(finalMatrix.size() / 2);

    }

    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.size(); i++) {
            min = Math.min(min, matrix.get(i).get(0));
            max = Math.max(max, matrix.get(i).get(matrix.get(i).size() - 1));
        }
        int total = (matrix.size() * matrix.get(0).size() + 1) / 2;
        while (min <= max) {
            int mid = (min + max) / 2;
            int count = 0;
            for (int i = 0; i < matrix.size(); i++) {
                count += getCountLess(matrix.get(i), mid);
            }
            if (count < total) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min;
    }

    public static int getCountLess(ArrayList<Integer> arrayList, int value) {
        int low = 0;
        int high = arrayList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arrayList.get(mid) <= value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static List<Integer> merge(List<Integer> matrix1, List<Integer> matrix2) {
        List<Integer> integers = new ArrayList<>(matrix1.size() + matrix2.size());

        int index1 = 0;
        int index2 = 0;
        while (index1 < matrix1.size() && index2 < matrix2.size()) {
            if (matrix1.get(index1) < matrix2.get(index2)) {
                integers.add(matrix1.get(index1++));
            } else {
                integers.add(matrix2.get(index2++));
            }
        }
        while (index1 < matrix1.size()) {
            integers.add(matrix1.get(index1++));
        }
        while (index2 < matrix2.size()) {
            integers.add(matrix2.get(index2++));
        }
        return integers;

    }

    public static void main(String[] args) {
        Integer[][] arr = {{1, 2, 6, 6, 10}, {2, 4, 4, 5, 7}, {2, 5, 5, 6, 6}};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new ArrayList<>(Arrays.asList(arr[i])));
        }
        getMedian(list);
    }
}
