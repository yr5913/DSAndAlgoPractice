package v2.linkedlist2;

import v2.linkedlist1.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        while (fast != null) {
            head = head.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            if (head == fast) {
                return true;
            }
        }
        return false;
    }
}
