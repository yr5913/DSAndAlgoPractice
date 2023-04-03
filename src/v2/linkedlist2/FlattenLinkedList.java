package v2.linkedlist2;

public class FlattenLinkedList {

    public static Node flattenLinkedList(Node start) {
        if (start == null && start.next == null) {
            return start;
        }
        Node head = new Node(0);
        head.child = start;
        Node next = start.next;
        start.next = null;
        while (next != null) {
            Node first = head.child;
            Node second = next;
            Node firstPrev = head;
            while (first != null || second != null) {
                if (first == null) {
                    firstPrev.child = second;
                    break;
                } else if (second == null) {
                    break;
                }
                if (first.data > second.data) {
                    Node tempSecond = second;
                    second = second.child;
                    firstPrev.child = tempSecond;
                    tempSecond.child = first;
                } else {
                    first = first.child;
                }
                firstPrev = firstPrev.child;
            }
            Node temp = next;
            next = next.next;
            temp.next = null;
        }
        return head.child;
    }

    public static void main(String[] args) {
        Node node1 = new Node(2, new Node(4, new Node(6)));
        Node node2 = new Node(5, new Node(11, new Node(14)));
        Node node3 = new Node(22, new Node(25));
        Node node4 = new Node(26, new Node(28));
        Node node5 = new Node(39);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Node node = flattenLinkedList(node1);
        System.out.println(node);
    }
}
