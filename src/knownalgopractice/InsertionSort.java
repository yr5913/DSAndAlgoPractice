package knownalgopractice;

public class InsertionSort {


    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] >= current) {
                    array[j + 1] = array[j];
                } else
                    break;
            }
            array[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,6,5,8,3,4,1,0,-6,-6,27,89,56};
        insertionSort(arr);
        System.out.println(arr);
    }
}
