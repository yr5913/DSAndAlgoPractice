package arrays1;

public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxPrice = 0;
        int lastVar = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>lastVar){
                int diff = prices[i]-lastVar;
                maxPrice = Math.max(maxPrice, diff);
            }else{
                lastVar=prices[i];
            }
        }
        return maxPrice;
    }
}
