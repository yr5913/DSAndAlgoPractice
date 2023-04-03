package v2.array3;

public class Power {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / x * (myPow(1 / x, Integer.MAX_VALUE));
            }
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n) : x * myPow(x * x, n);
    }
}
