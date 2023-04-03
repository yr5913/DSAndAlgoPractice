package v2.stackandqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ImplementStackUsingQueue {
}

class MyStack {
    Queue<Integer> queue;
    int top = 0;
    public MyStack() {
        this.queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int size = queue.size();
       for(int i=0;i<size-1;i++){
            top = queue.remove();
           queue.add(top);
       }
       return queue.remove();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
