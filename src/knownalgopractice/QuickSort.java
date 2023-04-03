package knownalgopractice;

public class QuickSort {


    public static void quickSort(int[] array) {

    }

    public static void quickSortHelper(int[] array, int start, int end) {
        if (start > end) {
            return;
        }
        int pivot = (start + end) / 2;
        int i = start;
        int j = end;
        while (i < j) {
            if (array[i] > array[pivot] && array[j] < array[pivot]) {
                System.out.println("hello");
            }
        }
    }
}
