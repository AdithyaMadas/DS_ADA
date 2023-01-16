package linkedList.singleLinkedList;

public class Insertion {
    static Node insertAtBeginning(Node head, int x) {
        if (head == null) {
            head = new Node(x);
            return head;
        }
        Node toInsert = new Node(x);
        toInsert.next = head;
        head = toInsert;
        return head;
    }

    //Function to insert a node at the end of the linked list.
    static Node insertAtEnd(Node head, int x) {
        if (head == null) {
            head = new Node(x);
            return head;
        }
        Node toInsert = new Node(x), curr = head;
        while (curr.next != null) {
            curr = curr.next;
            System.out.println();
        }
        curr.next = toInsert;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(insertAtBeginning(insertAtEnd(insertAtEnd(insertAtBeginning(null, 10), 20), 30), 5));

    }
}
