package v2.stackandqueue;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    Integer peek = null;

    public MyQueue() {

    }

    public void push(int x) {
        stack.push(x);
        if (peek != null) {
            peek = x;
        }
    }

    public int pop() {
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        int value = stack2.pop();
        if (!stack2.isEmpty()) {
            peek = stack2.peek();
        } else {
            peek = null;
        }
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
        return value;
    }

    public int peek() {
        return peek;
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
