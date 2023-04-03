package v2.myPractice;

import v2.linkedlist1.ListNode;

public class SwapNodes {

    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode temp = head;
        ListNode previous = newHead;
        while (temp != null && temp.next != null) {
            ListNode nextNode = temp.next.next;
            previous.next = temp.next;
            temp.next.next = temp;
            temp.next = nextNode;
            previous = temp;
            temp = temp.next;
        }
        return newHead.next;
    }
}
