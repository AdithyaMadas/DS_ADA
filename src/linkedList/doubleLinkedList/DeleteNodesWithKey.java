package linkedList.doubleLinkedList;

public class DeleteNodesWithKey {

    class Node
    {
        int data;
        Node next;
        Node prev;
        Node(int data)
        {
            this.data = data;
            next = prev = null;
        }
    }

    static Node deleteAllOccurOfX(Node head, int x) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.data == x) {
                head = deleteNodeWithValueX(head, tmp);
            }
        }
        return head;
    }

    private static Node deleteNodeWithValueX(Node head, Node toDelete) {
        if (head == toDelete) {
            head = toDelete.next;
            toDelete.prev = null;
        } else {
            toDelete.prev.next = toDelete.next;
            toDelete.next.prev = toDelete.prev;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
