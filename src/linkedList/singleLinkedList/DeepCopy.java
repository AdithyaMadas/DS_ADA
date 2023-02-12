package linkedList.singleLinkedList;

import java.util.HashMap;

public class DeepCopy {
    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList(Node head) {
        Node iter = head, next;
        while (iter != null) {
            Node nextNode = iter.next;
            iter.next = new Node(iter.val);
            iter.next.next = nextNode;
            iter = iter.next.next;
        }

        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        Node dummyHead = new Node(-1);
        Node curr = dummyHead;
        iter = head;
        while (iter != null) {
            curr.next = iter.next;
            curr = curr.next;
            iter.next = iter.next.next;
            iter = iter.next;
        }
        return dummyHead.next;
    }


//    public static Node copyRandomList(Node head) {
//        HashMap<Node, Node> map = new HashMap<>();
//        Node curr = head;
//        Node newHead = new Node(-1);
//        Node currNew = newHead;
//        while (curr != null) {
//            currNew.next = new Node(curr.val);
//            map.put(curr, currNew.next);
//            curr = curr.next;
//            currNew = currNew.next;
//        }
//        curr = head;
//        while (curr != null) {
//            if (curr.random != null) {
//                map.get(curr).random = map.get(curr.random);
//            }
//            curr = curr.next;
//        }
//        return newHead.next;
//    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.random = node.next;
        node.next.random = node.next;
        Node copy = copyRandomList(node);

    }
}
