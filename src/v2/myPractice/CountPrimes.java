package v2.myPractice;

public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < Math.sqrt(n); j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime)
                count++;
        }
        return count;
    }
}
