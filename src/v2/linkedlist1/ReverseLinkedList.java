package v2.linkedlist1;

public class ReverseLinkedList {

    public ListNode reverseListFirst(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = previous;
            previous = head;
            head = temp;
        }
        return previous;
    }


    public ListNode reverseListRec(ListNode head, ListNode previous) {
        if (head == null)
            return previous;
        ListNode current = head;
        head = head.next;
        current.next = previous;
        return reverseListRec(head, current);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode lastNode = reverseListFirst(head.next);
        head.next.next = head;
        head.next = null;
        return lastNode;
    }
}
