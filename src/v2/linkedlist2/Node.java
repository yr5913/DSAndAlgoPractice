package v2.linkedlist2;

public class Node {
    int data;
    Node next;
    Node child;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }

    public Node(int data, Node child) {
        this.data = data;
        this.next = null;
        this.child = child;
    }
}
