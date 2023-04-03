package v2.myPractice;

import v2.linkedlist1.ListNode;
import v2.util.Helpers;

public class LinkedListInsertionSort {

    public ListNode insertionSortList(ListNode head) {
        ListNode newNode = new ListNode(Integer.MIN_VALUE);
        newNode.next = head;
        ListNode previous = newNode;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            ListNode currentStart = newNode;
            while (currentStart != previous) {
                if (currentStart.next != null) {
                    if (currentStart.val <= current.val && currentStart.next.val >= current.val) {
                        ListNode temp = currentStart.next;
                        currentStart.next = current;
                        current.next = temp;
                        previous.next = next;
                        break;
                    }
                }
                currentStart = currentStart.next;
            }
            if (currentStart == previous)
                previous = current;
            current = next;
        }
        return newNode.next;
    }

    public static void main(String[] args) {
        new LinkedListInsertionSort().insertionSortList(Helpers.toLinkedListFromArrray(new int[]{4, 2, 1, 3}));
    }
}
