package stacksAndQueues;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    class DLinkedNode{
        DLinkedNode next;
        DLinkedNode prev;
        int key;
        int value;
    }

    int cap, count;
    DLinkedNode head, tail;
    Map<Integer, DLinkedNode> map;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.count = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        DLinkedNode dLinkedNode = map.get(key);
        if (dLinkedNode == null) {
            return -1;
        }
        moveToHead(dLinkedNode);
        return dLinkedNode.value;
    }

    public DLinkedNode popTail() {
        DLinkedNode node = tail.prev;
        tail.prev = node.prev;
        node.prev.next = tail;
        return node;
    }

    public void put(int key, int value) {
        DLinkedNode dLinkedNode = map.get(key);
            if (dLinkedNode != null) {
                dLinkedNode.value = value;
                moveToHead(dLinkedNode);
                return;
            }
        DLinkedNode newNode = new DLinkedNode();
        newNode.key = key;
        newNode.value = value;
        addNode(newNode);
        map.put(key, newNode);
        count++;
        if (count > cap) {
            map.remove(popTail().key);
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3);
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));

    }
}
