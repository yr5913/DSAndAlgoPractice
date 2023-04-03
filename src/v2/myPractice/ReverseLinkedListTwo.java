package v2.myPractice;

import v2.linkedlist1.ListNode;
import v2.util.Helpers;

public class ReverseLinkedListTwo {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left >= right) {
            return head;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        int count = 1;
        ListNode prev = newHead;
        ListNode leftNode = null;
        ListNode leftPrev = null;
        ListNode rightNode = null;
        ListNode current = head;
        while (current != null) {
            if (count == left) {
                leftPrev = prev;
                leftNode = current;
            } else if (count == right) {
                rightNode = current;
            }
            prev = current;
            count++;
            current = current.next;
        }
        int moves = right - left;
        for (int i = 0; i < moves; i++) {
            leftPrev.next = leftNode.next;
            leftNode.next = rightNode.next;
            rightNode.next = leftNode;
            leftNode = leftPrev.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        new ReverseLinkedListTwo().reverseBetween(Helpers.toLinkedListFromArrray(arr), 2, 4);
    }
}
