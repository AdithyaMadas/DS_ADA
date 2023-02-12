package linkedList.doubleLinkedList;

public class RemoveDuplicated {

    static class Node
    {
        int data;
        Node next,prev;

        Node(int x){
            data = x;
            next = null;
            prev = null;
        }
    }

    static Node removeDuplicates(Node head) {
        Node start = head;
        while (start != null && start.next != null) {
            if (start.data == start.next.data) {
                delete(start.next);
            } else {
                start = start.next;
            }
        }
        return head;
    }

    private static void delete(Node next) {
        next.prev.next = next.next;
        if(next.next!=null) next.next.prev = next.prev;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(1);
        node.next.prev = node;
        node.next.next = new Node(2);
        node.next.next.prev = node.next;
        Node node1 = removeDuplicates(node);

    }
}
