package stacksAndQueues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LFUCache {
    class Node {
        Node prev, next;
        int key, value, count;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
        }
    }

    class DLList {
        Node head, tail;
        int size;
        DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            head.next.prev = node;
            node.next = head.next;
            node.prev = head;
            head.next = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size > 0) {
                Node node = tail.prev;
                remove(node);
                return node;
            }
            else return null;
        }
    }


    int capacity;
    HashMap<Integer, Node> map;
    HashMap<Integer, DLList> countMap;

    int min, size;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        countMap = new HashMap<>();
        size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            update(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            update(node);
        } else {
            if (size >= capacity) {
                remove();
            }
            Node node = add(key, value);
            map.put(key, node);
        }
    }

    private void update(Node node) {
        DLList dlList = countMap.get(node.count);
        dlList.remove(node);
        if (node.count == min && dlList.size == 0) {
            countMap.remove(node.count);
            min++;
        }
        node.count++;
        countMap.computeIfAbsent(node.count, val -> new DLList()).add(node);
    }

    private void remove() {
        DLList dlList = countMap.get(min);
        map.remove(dlList.removeLast().key);
        size--;
    }
    private Node add(int key, int value) {
        Node node = new Node(key, value);
        countMap.computeIfAbsent(1, val -> new DLList()).add(node);
        min = 1;
        size++;
        return node;
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(3);
        lfu.put(1, 1);
        lfu.put(2, 2);
//        System.out.println(lfu.get(1));
        lfu.put(3, 3);
        lfu.put(4, 4);
        System.out.println(lfu.get(4));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(1));
        lfu.put(5, 5);

        System.out.println(lfu.get(1));
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(4));
        System.out.println(lfu.get(5));
    }
}
