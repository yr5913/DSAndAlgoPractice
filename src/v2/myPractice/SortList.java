package v2.myPractice;

import v2.linkedlist1.ListNode;
import v2.util.Helpers;

public class SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        return mergeList(sortList(head), sortList(secondHalf));
    }


    public ListNode mergeList(ListNode listNode1, ListNode listNode2) {
        ListNode newHead = new ListNode();
        ListNode merge = newHead;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                merge.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                merge.next = listNode2;
                listNode2 = listNode2.next;
            }
            merge = merge.next;
        }
        while (listNode1 != null) {
            merge.next = listNode1;
            listNode1 = listNode1.next;
            merge = merge.next;
        }
        while (listNode2 != null) {
            merge.next = listNode2;
            listNode2 = listNode2.next;
            merge = merge.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        new SortList().sortList(Helpers.toLinkedListFromArrray(new int[]{3, 4, 1}));
    }
}
