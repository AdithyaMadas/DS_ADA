package stacksAndQueues;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    class Node{
        Node prev, next;
        int key, value, count;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            count = 1;
        }
    }

    class DLinkedList{
        Node head, tail;

        public DLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public boolean isEmpty() {
            return head.next == tail;
        }

        //adds to head of dll
        public void add(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        public void remove(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        public void moveToHead(Node node) {
            remove(node);
            add(node);
        }

        public Node removeFromTail() {
            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    int capacity, minCount, size;
    Map<Integer, Node> valuesMap;
    Map<Integer, DLinkedList> countMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        valuesMap = new HashMap<>();
        countMap = new HashMap<>();
    }

    public int get(int key) {
        if(capacity==0) return -1;
        Node node = valuesMap.get(key);
        if (node == null) {
            return -1;
        }
        updateCount(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {

            return;
        }
        Node node = valuesMap.get(key);
        if (node != null) {
            node.value = value;
            updateCount(node);
        } else {
            Node newNode = new Node(key, value);
            valuesMap.put(key, newNode);
            if (capacity == minCount) {
                DLinkedList dLinkedList = countMap.get(minCount);
                valuesMap.remove(dLinkedList.removeFromTail().value);
                size--;
            }
            size++;
            minCount = 1;
            DLinkedList dList = countMap.getOrDefault(newNode.count, new DLinkedList());
            dList.add(newNode);
            countMap.put(newNode.count, dList);
        }
    }

    private void updateCount(Node node) {
        DLinkedList oldList = countMap.get(node.count);
        oldList.remove(node);
        if(node.count==minCount && oldList.isEmpty()) minCount++;
        node.count++;
        DLinkedList newList = countMap.getOrDefault(node.count, new DLinkedList());
        newList.add(node);
        countMap.put(node.count, newList);
    }
}
