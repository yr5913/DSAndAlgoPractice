package v2.myPractice;

import v2.linkedlist1.ListNode;
import v2.util.Helpers;

public class RemoveDuplicatesFromList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode newHead = new ListNode(1001);
        ListNode prevNode = newHead;
        while (current != null) {
            if (current.next != null) {
                if (current.val == current.next.val) {
                    ListNode next = current.next;
                    while (next != null) {
                        if (next.val != current.val) {
                            break;
                        }
                        next = next.next;
                    }
                    prevNode.next = next;
                    current = next;
                    continue;
                } else {
                    prevNode = current;
                }
            }
            current = current.next;
        }
        return head;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 4, 5};
        new RemoveDuplicatesFromList().deleteDuplicates(Helpers.toLinkedListFromArrray(arr));
    }
}
