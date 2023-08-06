package p0146;

import java.util.*;

class Node {
    Node prev;
    Node next;
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class DoublelyLinkedList {
    Node head;
    Node tail;
    int size = 0;

    public DoublelyLinkedList() {

    }

    public void putLast(Node node) {
        node.next = null;
        node.prev = null;
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            Node temp = tail;
            tail = node;
            tail.prev = temp;
        }
        size++;
    }

    public Node removeFirst() {
        if (head == null) {
            return null;
        }
        Node rtn = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
        return rtn;
    }

    public void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
        size--;
    }
}

class LRUCache {
    final int capacity;
    private Map<Integer, Node> nodeMap = new HashMap<>();

    private DoublelyLinkedList list = new DoublelyLinkedList();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) {
            return -1;
        } else {
            list.remove(node);
            list.putLast(node);
        }
        return node.val;
    }

    public void put(int key, int value) {
        Node found = nodeMap.get(key);
        if (found != null) {
            list.remove(found);
        }

        if (list.size == capacity) {
            Node removedNode = list.removeFirst();
            nodeMap.remove(removedNode.key);
        }

        Node newNode = new Node(key, value);
        list.putLast(newNode);
        nodeMap.put(key, newNode);
    }
}

public class App {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        lruCache.get(4);
        lruCache.get(3);
        lruCache.get(2);
        lruCache.get(1);
        lruCache.put(5, 5);
        lruCache.get(1);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.get(4);
        lruCache.get(5);
        // LRUCache lRUCache = new LRUCache(2);
        // lRUCache.put(1, 1); // cache is {1=1}
        // lRUCache.put(2, 2); // cache is {1=1, 2=2}
        // lRUCache.get(1); // return 1
        // lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        // lRUCache.get(2); // returns -1 (not found)
        // lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        // lRUCache.get(1); // return -1 (not found)
        // lRUCache.get(3); // return 3
        // lRUCache.get(4); // return 4
    }
}
