package v2.binarysearch;

public class NthRootOfM {

    public static double findNthRootOfM(int n, int m) {
        // Write your code here.
        double start = 1;
        double end = m;
        while (end - start > 0.0000001) {
            double mid = (start + end) / 2;
            if (multiply(mid, n) < m) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;

    }

    public static double multiply(double val, int n) {
        double retVal = 1;
        for (int i = 0; i < n; i++) {
            retVal *= val;
        }
        return retVal;
    }
}
