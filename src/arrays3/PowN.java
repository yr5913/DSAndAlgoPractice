package arrays3;

public class PowN {

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 0 || x == 1)
            return x;
        double value = x;
        if (n < 0)
            value = 1 / x;
        x = value;
        long i = 1;
        long l = n;
        l = Math.abs(l);
        while (i < l) {
            if (2 * i <= l) {
                value = value * value;
                i = 2 * i;
            } else {
                for (long k = i; k < l; k++) {
                    value = value * x;
                }
                return value;
            }
        }
        return value;

    }

    public double pow(double x, int n) {
        if (n == 0)
            return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE)
                return 1 / x * pow(1 / x, Integer.MAX_VALUE);
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
    }


    public static void main(String[] args) {
        new PowN().myPow(2.00000,
                -2147483648);
    }
}
