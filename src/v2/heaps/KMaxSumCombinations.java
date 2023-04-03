package v2.heaps;

import v2.util.MyHeap;

import java.util.*;

public class KMaxSumCombinations {

    public int[] solve(int[] A, int[] B, int C) {
        Integer[] intA = getIntegerArray(A);
        Integer[] intB = getIntegerArray(B);
        Arrays.sort(intA, (i1, i2) -> Integer.compare(i2, i1));
        Arrays.sort(intB, (i1, i2) -> Integer.compare(i2, i1));
        int lengthA = A.length;
        int lengthB = B.length;
        Set<Integer> set = new HashSet<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((i1, i2) -> i2[0] - i1[0]);

        int count = 0;
        int[] returnArray = new int[C];
        int[] obj = new int[3];
        obj[0] = intA[0] + intB[0];
        priorityQueue.add(obj);
        set.add(0);
        while (!priorityQueue.isEmpty() && count < C) {
            int[] head = priorityQueue.remove();
            returnArray[count++] = head[0];
            int x = head[1];
            int y = head[2];
            if (x + 1 < lengthA) {
                int index = (x + 1) * lengthB + y;
                if (!set.contains(index)) {
                    priorityQueue.add(createObj(x + 1, y, intA, intB));
                    set.add(index);
                }
            }
            if (y + 1 < lengthB) {
                int index = (x) * lengthB + y + 1;
                if (!set.contains(index)) {
                    priorityQueue.add(createObj(x, y + 1, intA, intB));
                    set.add(index);
                }
            }
        }
        return returnArray;
    }

    public int[] createObj(int x, int y, Integer[] A, Integer[] B) {
        int[] obj = new int[3];
        obj[0] = A[x] + B[y];
        obj[1] = x;
        obj[2] = y;
        return obj;
    }

    public Integer[] getIntegerArray(int[] arr) {
        Integer[] convert = new Integer[arr.length];
        int index = 0;
        for (int num : arr) {
            convert[index++] = num;
        }
        return convert;
    }

    public int[] createObj(int x, int y, int[] A, int[] B) {
        int[] obj = new int[3];
        obj[0] = A[x] + B[y];
        obj[1] = x;
        obj[2] = y;
        return obj;
    }

    public int[] solveB(int[] A, int[] B, int C) {
        A = sort(A);
        B = sort(B);
        int lengthA = A.length;
        int lengthB = B.length;
        Set<Integer> set = new HashSet<>();
        MyHeap<int[]> myHeap = new MyHeap<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int count = 0;
        int[] returnArray = new int[C];
        int[] obj = new int[3];
        obj[0] = A[0] + B[0];
        myHeap.add(obj);
        set.add(0);
        while (!myHeap.isEmpty() && count < C) {
            int[] head = myHeap.remove();
            returnArray[count++] = head[0];
            int x = head[1];
            int y = head[2];
            if (x + 1 < lengthA) {
                int index = (x + 1) * lengthB + y;
                if (!set.contains(index)) {
                    myHeap.add(createObj(x + 1, y, A, B));
                    set.add(index);
                }
            }
            if (y + 1 < lengthB) {
                int index = (x) * lengthB + y + 1;
                if (!set.contains(index)) {
                    myHeap.add(createObj(x, y + 1, A, B));
                    set.add(index);
                }
            }
        }
        return returnArray;
    }

    public int[] sort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int[] left = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] right = Arrays.copyOfRange(array, array.length / 2, array.length);
        return merge(sort(left), sort(right));
    }

    public int[] merge(int[] left, int[] right) {
        int[] finalArray = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int finalIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] > right[rightIndex]) {
                finalArray[finalIndex++] = left[leftIndex++];
            } else {
                finalArray[finalIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            finalArray[finalIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            finalArray[finalIndex++] = right[rightIndex++];
        }
        return finalArray;
    }

    public static void main(String[] args) {
        int[] arr = {59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83};
        int[] arr2 = {59, 63, 65, 6, 46, 82, 28, 62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83};
        new KMaxSumCombinations().solve(arr, arr2, 1);
    }


}

