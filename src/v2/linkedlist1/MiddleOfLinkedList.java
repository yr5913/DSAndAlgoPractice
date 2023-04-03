package v2.linkedlist1;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null) {
            head = head.next;
            fastNode = fastNode.next.next;
        }
        return head;
    }
}
