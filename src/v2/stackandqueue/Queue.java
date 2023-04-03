package v2.stackandqueue;

import java.util.LinkedList;

public class Queue {
    LinkedList<Integer> list;

    Queue() {
        // Implement the Constructor
        list = new LinkedList<>();
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        return list.isEmpty();
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        list.add(data);
    }

    int dequeue() {
        // Implement the dequeue() function
        if(isEmpty()){
            return -1;
        }
        return list.remove();
    }

    int front() {
        // Implement the front() function
        if(isEmpty()){
            return -1;
        }
        return list.getFirst();
    }
}
