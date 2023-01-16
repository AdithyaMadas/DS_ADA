package linkedList.singleLinkedList;

class Node {
    int data;
    Node next;

    Node() { data = 0; }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }

    Node(int d) { data = d; }  //constructor to create a new node
}

public class Implementation {
    static Node constructLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(constructLL(new int[]{1, 2, 3, 4, 5}));
    }
}
