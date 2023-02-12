package linkedList.singleLinkedList;

public class FlattenLinkedList {

    static class Node
    {
        int data;
        Node next;
        Node bottom;

        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }

    static Node flatten(Node root) {
        Node curr = null;
        while (root != null) {
            Node nextRoot = root.next;
            curr = merge(root, curr);
            root = nextRoot;
        }
        return curr;
    }

    private static Node merge(Node root, Node curr) {
        Node dummy = new Node(-1);
        Node currNode = dummy;
        while (root != null && curr != null) {
            if (root.data > curr.data) {
                currNode.bottom = null;
                currNode.next = curr;
                currNode = currNode.next;
                curr = curr.next;
            } else {
                currNode.bottom = null;
                currNode.next = root;
                currNode = currNode.next;
                root = root.bottom;
            }
        }
        while (root != null) {
            currNode.bottom = null;
            currNode.next = root;
            currNode = currNode.next;
            root = root.bottom;
        }
        while (curr != null) {
            currNode.bottom = null;
            currNode.next = curr;
            currNode = currNode.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.bottom = new Node(7);
        node.bottom.bottom = new Node(8);
        node.bottom.bottom.bottom = new Node(20);
        node.next = new Node(10);
        node.next.bottom = new Node(20);
        node.next.next = new Node(1);
        node.next.next.bottom = new Node(2);
        node.next.next.bottom.bottom = new Node(4);
        Node flatten = flatten(node);
    }
}
