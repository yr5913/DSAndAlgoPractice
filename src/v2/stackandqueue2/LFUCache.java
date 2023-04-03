package v2.stackandqueue2;

import java.util.HashMap;
import java.util.Map;

class LFUCache {
    Map<Integer, DoublyLinkedList> map;
    Map<Integer, LRUListNode> key;
    int capacity;
    int min;

    public LFUCache(int capacity) {
        key = new HashMap<>(capacity);
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        LRUListNode current = this.key.get(key);
        if (current != null) {
            updatePriority(current);
            return current.value;
        }
        return -1;
    }

    public void updatePriority(LRUListNode listNode) {
        int priority = listNode.priority;
        DoublyLinkedList belongTo = this.map.get(priority);
        belongTo.remove(listNode);
        listNode.priority++;
        DoublyLinkedList newLinked = this.map.getOrDefault(listNode.priority, new DoublyLinkedList());
        newLinked.addFront(listNode);
        if (belongTo.size == 0 && priority == min) {
            min = listNode.priority;
        }
        map.put(listNode.priority, newLinked);
    }

    public void put(int key, int value) {
        LRUListNode current = this.key.get(key);
        if (current != null) {
            current.value = value;
            updatePriority(current);
        } else {
            if (this.key.size() == capacity) {
                current = map.get(min).removeLast();
                this.key.remove(current.key);
            }
            DoublyLinkedList linkedList = map.getOrDefault(1, new DoublyLinkedList());
            LRUListNode listNode = new LRUListNode();
            listNode.key = key;
            listNode.value = value;
            listNode.priority = 1;
            linkedList.addFront(listNode);
            map.put(1, linkedList);
            this.key.put(key, listNode);
            min = 1;
        }
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        lfuCache.get(1);
        lfuCache.put(3, 3);
        lfuCache.get(2);
        lfuCache.get(3);
        lfuCache.put(4, 4);
        lfuCache.get(1);
        lfuCache.get(3);
        lfuCache.get(4);
    }
}

class DoublyLinkedList {
    LRUListNode head;
    LRUListNode tail;
    int size;

    public DoublyLinkedList() {
        head = new LRUListNode();
        tail = new LRUListNode();
        head.next = tail;
        tail.prev = head;
        size = 0;

    }

    public void addFront(LRUListNode node) {
        LRUListNode next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
        size++;

    }

    public LRUListNode removeLast() {
        LRUListNode prev = tail.prev;
        tail.prev = prev.prev;
        tail.prev.next = tail;
        prev.prev = null;
        prev.next = null;
        size--;
        return prev;
    }

    public void remove(LRUListNode listNode) {
        LRUListNode next = listNode.next;
        LRUListNode prev = listNode.prev;
        prev.next = next;
        next.prev = prev;
        size--;
    }
}

class LRUListNode {
    int value;
    int priority;
    int key;
    LRUListNode next;
    LRUListNode prev;

    public LRUListNode() {
    }

    public LRUListNode(int val) {
        this.value = val;
    }

}
