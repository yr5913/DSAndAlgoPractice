package v2.linkedlist2;

import v2.linkedlist1.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        if (len < k) {
            return head;
        }
        temp = head;
        int times = len / k;
        ListNode firstNode = null;
        ListNode returnHead = null;
        while (times-- != 0) {
            int kCopy = k;
            ListNode previous = null;
            ListNode tempFirst = temp;
            for (int i = 0; i < kCopy; i++) {
                ListNode dummy = temp.next;
                temp.next = previous;
                previous = temp;
                temp = dummy;
            }
            if (firstNode != null) {
                firstNode.next = previous;
            } else {
                returnHead = previous;
            }
            firstNode = tempFirst;
        }
        firstNode.next = temp;
        return returnHead;
    }


}
