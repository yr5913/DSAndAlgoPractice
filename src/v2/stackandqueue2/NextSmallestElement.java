package v2.stackandqueue2;

import java.util.Stack;

public class NextSmallestElement {
    public int[] prevSmaller(int[] A) {
        Stack<Integer> stack = new Stack();

        int[] ans = new int[A.length];

        for(int i = 0;i<A.length;i++ ){
            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                while (!stack.isEmpty() && stack.peek() >= A[i] ){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    ans[i] = -1;
                }else{
                    ans[i] = stack.peek();
                }
            }

            stack.push(A[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {34, 35, 27, 42, 5, 28, 39, 20, 28};
        new NextSmallestElement().prevSmaller(arr);
    }
}
