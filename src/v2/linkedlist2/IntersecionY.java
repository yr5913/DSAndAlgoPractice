package v2.linkedlist2;

import v2.linkedlist1.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersecionY {

    public ListNode getIntersectionHashing(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode longNode = headA;
        ListNode shortNode = headB;
        while (longNode != null) {
            lenA++;
            longNode = longNode.next;
        }
        while (shortNode != null) {
            lenB++;
            shortNode = shortNode.next;
        }

        longNode = headA;
        shortNode = headB;
        if (lenA < lenB) {
            longNode = headB;
            shortNode = headA;
        }
        int diff = Math.abs(lenA - lenB);
        for (int i = 0; i < diff; i++) {
            longNode = longNode.next;
        }
        while (longNode != null) {
            if (longNode == shortNode) {
                return longNode;
            }
            longNode = longNode.next;
            shortNode = shortNode.next;
        }

        return null;
    }
}
