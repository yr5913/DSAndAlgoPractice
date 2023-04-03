package v2.heaps;

import v2.util.Helpers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedArrays {


    public static ArrayList<Integer> mergeKSortedArraysMinHeap(ArrayList<ArrayList<Integer>> kArrays, int k) {

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(i -> i[0]));
        for (int i = 0; i < k; i++) {
            int[] arr = new int[3];
            arr[0] = kArrays.get(i).get(0);
            arr[1] = i;
            arr[2] = 0;
            priorityQueue.add(arr);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            int[] removed = priorityQueue.remove();
            arrayList.add(removed[0]);
            if (removed[2] < kArrays.get(removed[1]).size() - 1) {
                int[] arr = new int[3];
                arr[0] = kArrays.get(removed[1]).get(removed[2] + 1);
                arr[1] = removed[1];
                arr[2] = removed[2] + 1;
                priorityQueue.add(arr);
            }
        }
        return arrayList;
    }

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        if (k == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = kArrays.get(0);
        for (int i = 1; i < kArrays.size(); i++) {
            list = merge(list, kArrays.get(i));
        }
        return list;
    }


    public static ArrayList<Integer> mergeKSortedArraysYu(ArrayList<ArrayList<Integer>> kArrays, int k) {

        if (k == 0) {
            return new ArrayList<>();
        }
        int[] kIndexes = new int[k];
        int total = 0;
        for (int i = 0; i < kArrays.size(); i++) {
            total += kArrays.get(i).size();
        }
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>(total);
        while (count < total) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < k; i++) {
                if (kIndexes[i] < kArrays.get(i).size()) {
                    if (kArrays.get(i).get(kIndexes[i]) < min) {
                        min = kArrays.get(i).get(kIndexes[i]);
                        index = i;
                    }
                }
            }
            list.add(min);
            kIndexes[index]++;
            count++;
        }
        return list;
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
        ArrayList<Integer> finalArray = new ArrayList(left.size() + right.size());
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                finalArray.add(left.get(leftIndex++));
            } else {
                finalArray.add(right.get(rightIndex++));
            }
        }
        while (leftIndex < left.size()) {
            finalArray.add(left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            finalArray.add(right.get(rightIndex++));
        }
        return finalArray;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 9};
        int[] arr2 = {1, 2, 3, 8};
        ArrayList<Integer> arrayList1 = Helpers.toArrayListFromArray(arr1);
        ArrayList<Integer> arrayList = Helpers.toArrayListFromArray(arr2);
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        arrayLists.add(arrayList1);
        arrayLists.add(arrayList);

        mergeKSortedArraysMinHeap(arrayLists, 2);
    }
}
