package v2.stackandqueue2;

import java.util.ArrayDeque;

public class SlidingWindowMinimum {

    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        int[] ans = new int[a.length];
        ArrayDeque<Integer>[] arrayDeques = new ArrayDeque[a.length];

        for (int i = 0; i < a.length; i++) {

        }
        return ans;
    }

    public static void main(String[] args) {
        maxMinWindow(new int[]{-2, 12, -1, 1, 20, 1}, 4);
    }
}
