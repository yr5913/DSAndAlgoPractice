package v2.myPractice;

import v2.linkedlist1.ListNode;
import v2.util.Helpers;

public class ReorderList {

    public void reorderList(ListNode head) {


        ListNode temp = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            temp = temp.next;
            fast = fast.next.next;
        }
        if (temp == head) {
            return;
        }
        ListNode back = new ListNode();
        ListNode previous = back;
        back.next = temp.next;
        temp.next = null;
        ListNode current = back.next;
        back.next = null;
        while (current.next != null) {
            temp = current;
            current = current.next;
            temp.next = previous;
            previous = temp;

        }
        current.next = previous;
        ListNode headTemp = head;
        while (current.next != null) {
            temp = headTemp;
            headTemp = headTemp.next;
            ListNode tempCurrent = current;
            temp.next = tempCurrent;
            current = current.next;
            tempCurrent.next = headTemp;
        }
        if (headTemp != null) {
            current.next = headTemp;
        }

    }

    public static void main(String[] args) {
        new ReorderList().reorderList(Helpers.toLinkedListFromArrray(new int[]{1, 2, 3, 4, 5}));
    }
}
