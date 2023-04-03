package v2.heaps;

import java.util.Arrays;

public class ImplementMinHeap {

    static int[] minHeap(int n, int[][] q) {
        // Write your code here.
        int[] heap = new int[q.length];
        int[] remove = new int[q.length];
        int index = 0;
        int endIndex = -1;
        for (int i = 0; i < q.length; i++) {
            if (q[i][0] == 0) {
                insertToHeap(heap, ++endIndex, q[i][1]);
            } else {
                remove[index++] = removeFromHeap(heap, endIndex--);
            }
        }

        return Arrays.copyOfRange(remove, 0, index);
    }

    static void insertToHeap(int[] heap, int endIndex, int element) {
        heap[endIndex] = element;
        int child = endIndex;
        int parentIndex = (child - 1) / 2;
        while (parentIndex > -1 && heap[parentIndex] > heap[child]) {
            swap(heap, child, parentIndex);
            child = parentIndex;
            parentIndex = (child - 1) / 2;
        }
    }

    static int removeFromHeap(int[] heap, int endIndex) {
        int minElement = heap[0];
        heap[0] = heap[endIndex];
        int parent = 0;
        while (true) {
            int child1 = 2 * parent + 1;
            int child2 = child1 + 1;
            int child1Val = child1 < endIndex ? heap[child1] : Integer.MAX_VALUE;
            int child2Val = child2 < endIndex ? heap[child2] : Integer.MAX_VALUE;
            int parentVal = heap[parent];
            if (parentVal <= child1Val && parentVal <= child2Val) {
                break;
            } else if (parentVal > child1Val && parentVal > child2Val) {
                if (child1Val < child2Val) {
                    swap(heap, child1, parent);
                    parent = child1;
                } else {
                    swap(heap, child2, parent);
                    parent = child2;
                }
            } else if (parentVal > child1Val) {
                swap(heap, child1, parent);
                parent = child1;
            } else if (parentVal > child2Val) {
                swap(heap, child2, parent);
                parent = child2;
            } else {
                break;
            }
        }
        return minElement;
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[][] ar = {{0, 32}, {1}, {0, 30}, {0, 48}, {0, 13}, {1}, {0, 10}, {1}, {0, 8}, {0, 38}};
        System.out.println(Arrays.toString(minHeap(10, ar)));
    }
}
