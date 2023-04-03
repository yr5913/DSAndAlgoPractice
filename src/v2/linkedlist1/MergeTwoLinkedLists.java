package v2.linkedlist1;

public class MergeTwoLinkedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {


//        if(list1 ==null && list2==null){
//            return head;
//        }
//        if(list1==null){
//            head = list2;
//            list2  = list2.next;
//            current = head;
//            current.next = null;
//        } else if(list2==null){
//            head = list1;
//            list1  = list1.next;
//            current = head;
//            current.next = null;
//        }else{
//            if(list1.val<list2.val){
//
//            }else {
//
//            }
//        }
        ListNode head = null;
        ListNode current = null;
        while (list1!=null && list2!=null){
            if(list1.val<list2.val){
                if(head==null){
                    head = list1;
                    list1  = list1.next;
                    current = head;
                    current.next = null;

                }else{
                    current.next = list1;
                    current = current.next;
                    list1 = list1.next;
                    current.next = null;
                }
            }else {
                if(head==null){
                    head = list2;
                    list2  = list2.next;
                    current = head;
                    current.next = null;

                }else{
                    current.next = list2;
                    current = current.next;
                    list2 = list2.next;
                    current.next = null;
                }
            }

        }
        while (list1!=null){
            if(head==null){
                head = list1;
                list1  = list1.next;
                current = head;
                current.next = null;

            }else{
                current.next = list1;
                current = current.next;
                list1 = list1.next;
                current.next = null;
            }
        }
        while (list2!=null){
            if(head==null){
                head = list2;
                list2  = list2.next;
                current = head;
                current.next = null;

            }else{
                current.next = list2;
                current = current.next;
                list2 = list2.next;
                current.next = null;
            }
        }
        return head;
    }

}