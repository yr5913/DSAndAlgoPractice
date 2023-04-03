package v2.myPractice;

import v2.linkedlist1.ListNode;
import v2.util.Helpers;

public class PartitionList {


    public ListNode partition(ListNode head, int x) {

        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode previous = newHead;
        ListNode firstGreater = null;
        ListNode firstGreaterPrevious = newHead;
        ListNode current = head;
        while (current != null) {
            if (current.val >= x) {
                firstGreaterPrevious = previous;
                firstGreater = current;
                break;
            }
            previous = current;
            current = current.next;
        }
        if (firstGreater != null) {
            current = firstGreater.next;
            previous = firstGreater;
            while (current != null) {
                if (current.val < x) {
                    previous.next = current.next;
                    current.next = firstGreater;
                    firstGreaterPrevious.next = current;
                    firstGreaterPrevious = current;
                    current = previous.next;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 0, 5, 2};
        ListNode listNode = Helpers.toLinkedListFromArrray(arr);
        new PartitionList().partition(listNode, 2);
    }
}
