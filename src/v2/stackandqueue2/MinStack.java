package v2.stackandqueue2;


import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() > val) {
            minStack.push(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        if (minStack.peek() == val) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
