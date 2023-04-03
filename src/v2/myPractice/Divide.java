package v2.myPractice;

public class Divide {

    public int divide(int dividend, int divisor) {

        int negative = 1;
        long newDividend = dividend;
        if(dividend==Integer.MIN_VALUE){
            if(divisor ==1){
                return Integer.MIN_VALUE;
            }else if(divisor ==-1){
                return Integer.MAX_VALUE;
            }
        }
        if (dividend < 0) {
            newDividend = Math.abs(newDividend);
            negative = -negative;
        }

        long newDivisor = divisor;
        if (divisor < 0) {
            newDivisor = Math.abs(newDivisor);
            negative = -negative;
        }
        long sum = newDivisor;
        long count = 0;
        while (sum <= newDividend) {
            sum += newDivisor;
            count++;
        }
        int ans = Integer.MAX_VALUE;
        if(count<=Integer.MAX_VALUE){
            ans = (int) count;
        }
        return negative < 0 ? -ans : ans;
    }

    public static void main(String[] args) {
        new Divide().divide(-2147483648, -3);
    }
}
