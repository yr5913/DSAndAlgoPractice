package v2.linkedlist1;

import v2.util.Helpers;

public class RemoveNodeFromEnd {


    public ListNode removeNthFromEndPass(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if (len == n) {
            return head.next;
        }
        int fromFront = len - n;
        int current = 1;
        temp = head;
        while (current != fromFront) {
            temp = temp.next;
            current++;
        }
        temp.next = temp.next.next;
        return head;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode firstPointer = head;
        ListNode secondPointer = head;
        int count = 0;
        while (firstPointer != null) {
            if (count > n) {
                secondPointer = secondPointer.next;
            }
            firstPointer = firstPointer.next;
            count++;
        }
        if (count == n ) {
            return head.next;
        }
        secondPointer.next = secondPointer.next.next;
        return head;
    }

    public static void main(String[] args) {
        int[] arry = {1,2,3,4,5};
        new RemoveNodeFromEnd().removeNthFromEnd(Helpers.toLinkedListFromArrray(arry), 2);
    }
}
