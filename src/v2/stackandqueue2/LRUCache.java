package v2.stackandqueue2;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;


    }

    public int get(int key) {
        ListNode current = map.get(key);
        if (current != null) {
            if (current != tail) {
                if (current == head) {
                    head = current.next;
                    current.next.prev = null;

                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                current.prev = tail;
                current.next = null;
                tail.next = current;
                tail = current;
            }
            return current.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode current = map.get(key);
            current.value = value;
            if (current != tail) {
                if (current == head) {
                    head = current.next;
                    current.next.prev = null;

                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                current.prev = tail;
                current.next = null;
                tail.next = current;
                tail = current;
            }

        } else {
            if (head == null) {
                head = new ListNode();
                tail = head;
                tail.value = value;
                tail.key = key;
                map.put(key, head);
                return;
            }
            if (map.size() == capacity) {
                if (head == tail) {
                    map.remove(head.key);
                    head = new ListNode();
                    head.value = value;
                    head.key = key;
                    map.put(key, head);
                    return;
                }
                map.remove(head.key);
                head = head.next;
                head.prev = null;
            }
            tail.next = new ListNode();
            tail.next.prev = tail;
            tail = tail.next;
            tail.value = value;
            tail.key = key;
            map.put(key, tail);
        }

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        lruCache.get(2);
        lruCache.put(3, 2);
        lruCache.get(2);
        lruCache.get(3);
    }
}

class ListNode {
    int value;
    int key;
    ListNode next;
    ListNode prev;

    public ListNode() {
    }

    public ListNode(int val) {
        this.value = val;
    }

}