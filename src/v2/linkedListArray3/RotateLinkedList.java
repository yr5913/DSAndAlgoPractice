package v2.linkedListArray3;

import v2.linkedlist1.ListNode;

public class RotateLinkedList {

    public ListNode rotateRightArray(ListNode head, int k) {
        ListNode slow = head;
        int len = 0;
        while (slow != null) {
            slow = slow.next;
            len++;
        }
        if (head == null || k % len == 0)
            return head;
        int[] array = new int[len];
        slow = head;
        int i = 0;
        while (slow != null) {
            array[(i++ + k) % len] = slow.val;
            slow = slow.next;
        }
        slow = head;
        for (int num : array) {
            slow.val = num;
            slow = slow.next;
        }
        return head;
    }

    public ListNode rotateRight(ListNode head, int k) {
        ListNode slow = head;
        ListNode last = null;
        int len = 0;
        while (slow != null) {
            last = slow;
            slow = slow.next;
            len++;
        }
        if (head == null || k % len == 0) {
            return head;
        }
        k = len - k % len;
        slow = head;
        for (int i = 0; i < k - 1; i++) {
            slow = slow.next;
        }
        last.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
