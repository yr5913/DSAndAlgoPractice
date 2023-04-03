package v2.util;

public class PrintHelper {

    public static void printArray(Object[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (array.length > 0)
            sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(", ");
            sb.append(array[i]);
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (array.length > 0)
            sb.append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(", ");
            sb.append(array[i]);
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void printArrayTwoDimensional(int[][] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append("[");
            if (array[i].length > 0)
                sb.append(array[i][0]);
            for (int j = 1; j < array[i].length; j++) {
                sb.append(", ");
                sb.append(array[i][j]);
            }
            sb.append("]");
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
