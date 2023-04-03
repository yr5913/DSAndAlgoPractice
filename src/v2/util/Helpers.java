package v2.util;

import v2.linkedlist1.ListNode;

import java.util.ArrayList;

public class Helpers {

    public static ListNode toLinkedListFromArrray(int[] array) {
        if (array.length == 0) {
            return null;
        }
        ListNode headNode = new ListNode(array[0]);
        ListNode currentNode = headNode;
        for (int i = 1; i < array.length; i++) {
            currentNode.next = new ListNode(array[i]);
            currentNode = currentNode.next;
        }
        return headNode;
    }

    public static <T> ArrayList<T> toArrayListFromArray(T[] arr) {
        ArrayList<T> list = new ArrayList<>();
        for (T t : arr) {
            list.add(t);
        }
        return list;
    }

    public static  ArrayList<Integer> toArrayListFromArray(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int t : arr) {
            list.add(t);
        }
        return list;
    }
}
