package v2.stackandqueue;

public class Stack {
    int[] arr = new int[100];
    int index = 0;

    public Stack(int num) {
        arr = new int[num];
    }

    public void push(int num) {
        // Write your code here.
        if (isFull() == 0)
            arr[index++] = num;
    }

    public int pop() {
        // Write your code here.
        if (isEmpty() == 1)
            return -1;

        return arr[--index];

    }

    public int top() {
        // Write your code here.
        return arr[index - 1];
    }

    public int isEmpty() {
        // Write your code here.
        return index == 0 ? 1 : 0;
    }

    public int isFull() {
        // Write your code here.
        return index == arr.length ? 1 : 0;
    }
}
