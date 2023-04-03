package v2.binarysearch;

import java.util.Arrays;

public class ChessTournament {

    public static int chessTournament(int[] positions, int n, int c) {
        // Write your code here.
        if (positions.length < c) {
            return -1;
        }
        Arrays.sort(positions);
        int high = positions[positions.length - 1] - positions[0];
        int low = 1;
        while (low <= high) {
            int focus = (low + high) / 2;
            int rooms = 1;
            int prev = positions[0];
            for (int i = 1; i < positions.length; i++) {
                if (positions[i] - prev >= focus) {
                    rooms++;
                    prev = positions[i];
                }
            }
            if (rooms < c) {
                high = focus - 1;
            } else {
                low = focus + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 2, 1};
        System.out.println(chessTournament(a, a.length, 3));
    }
}
