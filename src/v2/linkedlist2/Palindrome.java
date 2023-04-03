package v2.linkedlist2;

import v2.linkedlist1.ListNode;
import v2.util.Helpers;

import java.util.Stack;

public class Palindrome {
    public boolean isPalindromeStack(ListNode head) {
        ListNode temp = head;
        int len = 0;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        temp = head;
        int current = 0;
        while (temp != null) {
            if (current < len / 2) {
                stack.push(temp.val);
            } else if (current > len / 2 || len % 2 == 0) {
                if (stack.pop() != temp.val) {
                    return false;
                }
            }
            current++;
            temp = temp.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next==null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;
        if (slow.next != null && slow.next.next != null) {
            ListNode curr = slow.next;
            ListNode next = curr.next;
            curr.next = null;
            while (next != null) {
                curr = next;
                next = curr.next;
                curr.next = middle.next;
                middle.next.next = null;
                middle.next = curr;
            }
        }
        slow = head;
        middle = middle.next;
        while (middle != null) {
            if (middle.val != slow.val) {
                return false;
            }
            middle = middle.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        int array[] = {1,0,3,4,0,1};
        new Palindrome().isPalindrome(Helpers.toLinkedListFromArrray(array));
    }
}
