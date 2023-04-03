package v2.linkedlist1;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode();
        ListNode current = head;
        int rem = 0;
        while (l1 != null || l2 != null) {
            int val1 = 0;
            int val2 =0;
            if(l1!=null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + rem;
            rem = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        if (rem != 0) {
            current.next = new ListNode(rem);
        }
        return head.next;

    }
}
