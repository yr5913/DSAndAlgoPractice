package v2.myPractice;

public class Product {
    public int[] productExceptSelfY(int[] nums) {

        int product = 1;
        int ans[] = new int[nums.length];
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                product *= nums[i];
            } else {
                zeroCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                if (zeroCount == 1) {
                    if (nums[i] == 0) {
                        ans[i] = product;
                    } else {
                        ans[i] = 0;
                    }
                } else {
                    ans[i] = 0;
                }
            } else {
                ans[i] = product / nums[i];
            }
        }

        return ans;

    }

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int prod1 = 1;
        int prod2 = 1;
        for (int i = 0; i < nums.length; i++) {
            left[i] = prod1 * nums[i];
            right[nums.length-i- 1] = prod2 * nums[nums.length-i-1];
        }
        for(int i=0;i<nums.length;i++){
            if(i!=0 && i!=nums.length-1){

            }
        }
        return null;
    }
}
