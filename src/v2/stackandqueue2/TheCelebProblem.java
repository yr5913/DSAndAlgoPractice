package v2.stackandqueue2;

public class TheCelebProblem {

    public static int findCelebrity(int n) {
        // Write your code here.
        int[] knownBy = new int[n];
        int[] knows = new int[n];
        for (int i = 0; i < n - 1; i++) {

        }
        for (int i = 0; i < n; i++) {
            if (knownBy[i] == n && knows[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static boolean knows(int x, int y) {
        if (x == 1)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        findCelebrity(2);
    }
}
