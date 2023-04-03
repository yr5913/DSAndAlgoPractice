package v2.linkedListArray3;

import java.util.ArrayList;

public class CopyListWithRandomPointer {
    public Node copyRandomListSpace(Node head) {
        Node newHead = new Node(0);
        ArrayList<Node> arrayList = new ArrayList<>();
        Node temp = newHead;
        int i = 0;
        Node slow = head;
        while (slow != null) {
            temp.next = new Node(slow.val);
            temp = temp.next;
            arrayList.add(temp);
            slow.val = i++;
            slow = slow.next;
        }
        slow = head;
        Node slowTwo = newHead.next;
        while (slow != null) {
            if (slow.random != null) {
                slowTwo.random = arrayList.get(slow.random.val);
            }
            slow = slow.next;
            slowTwo = slowTwo.next;
        }
        return newHead.next;
    }

    public Node copyRandomList(Node head) {
        Node slow = head;
        while (slow != null) {
            Node node = new Node(slow.val);
            node.next = slow.next;
            slow.next = node;
            slow = node.next;
        }
        slow = head;
        while (slow != null) {
            if (slow.random != null) {
                slow.next.random = slow.random.next;
            }
            slow = slow.next.next;
        }
        Node currentHead = new Node(0);
        Node prevHead = currentHead;
        slow = head;
        while (slow != null) {
            prevHead.next = slow.next;
            slow.next = slow.next.next;
            prevHead = prevHead.next;
            slow = slow.next;
        }
        return currentHead.next;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        node.next = node2;
        node.random = node2;
        node2.random = node2;
        new CopyListWithRandomPointer().copyRandomList(node);
    }
}
