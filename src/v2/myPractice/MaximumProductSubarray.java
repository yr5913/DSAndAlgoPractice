package v2.myPractice;

public class MaximumProductSubarray {

    public int maxProduct2(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        Integer firstNegativeProd = null;
        Integer afterFirstNegativeProd = null;
        int negativeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            firstNegativeProd = firstNegativeProd * nums[i];
            maxProduct = Math.max(firstNegativeProd, maxProduct);
            if (negativeCount > 0) {
                afterFirstNegativeProd = afterFirstNegativeProd * nums[i];
                maxProduct = Math.max(afterFirstNegativeProd, maxProduct);
            }
            if (nums[i] == 0) {
                firstNegativeProd = 1;
                afterFirstNegativeProd = 1;
                negativeCount = 0;
            } else if (nums[i] < 0) {
                negativeCount++;
            }
        }
        return maxProduct;
    }

    public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        Integer firstNegativeProd = null;
        Integer afterFirstNegativeProd = null;
        int negativeCount = 0;
        for (int i = 0; i < nums.length; i++) {
            firstNegativeProd = firstNegativeProd * nums[i];
            maxProduct = Math.max(firstNegativeProd, maxProduct);
            if (negativeCount > 0) {
                afterFirstNegativeProd = afterFirstNegativeProd * nums[i];
                maxProduct = Math.max(afterFirstNegativeProd, maxProduct);
            }
            if (nums[i] == 0) {
                firstNegativeProd = 1;
                afterFirstNegativeProd = 1;
                negativeCount = 0;
            } else if (nums[i] < 0) {
                negativeCount++;
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{0, 0, 0, -1, -9}));
    }
}
