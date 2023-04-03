package v2.linkedlist2;

import v2.linkedlist1.ListNode;
import v2.util.Helpers;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {

    public ListNode detectCycleHashing(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != slow) {
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 0, -4};
        ListNode listNode = Helpers.toLinkedListFromArrray(arr);
        ListNode head = listNode;
        int count = 0;
        ListNode temp = null;
        while (listNode.next != null) {
            if (count == 1)
                temp = listNode;
            listNode = listNode.next;
            count++;
        }
        listNode.next = temp;
        new DetectCycle().detectCycle(head);
    }
}
