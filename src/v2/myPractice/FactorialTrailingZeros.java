package v2.myPractice;

public class FactorialTrailingZeros {

    public int trailingZeroes(int n) {
        int x=5;
        int count = 0;
        while(x<=n){
            count+= (n/x);
            x=x*5;
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println( new FactorialTrailingZeros().trailingZeroes(30));
    }
}
