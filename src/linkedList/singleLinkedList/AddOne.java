package linkedList.singleLinkedList;

public class AddOne {

    static class Node{
        int data;
        Node next;

        Node(int x){
            data = x;
            next = null;
        }
    }

    public static Node addOne(Node head) {
        head = reverse(head, null);
        int carryForward = 1;
        Node start = head;
        while (carryForward != 0) {
            if (start.data != 9) {
                start.data += 1;
                carryForward = 0;
            } else {
                if (start.next == null) {
                    start.data = 0;
                    start.next = new Node(1);
                    carryForward = 0;
                } else {
                    start.data = 0;
                    start = start.next;
                }
            }
        }
        return reverse(head, null);
    }

    private static Node reverse(Node head, Node prev) {
        if (head == null) {
            return prev;
        }
        Node next = head.next;
        head.next = prev;
        return reverse(next, head);
    }

    public static void main(String[] args) {
        Node node = new Node(9);
        node = addOne(node);

    }
}
