package linkedList.singleLinkedList;

public class Sort012LinkedList {
    static Node segregate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node tmp = new Node(0), zero = null, ones = null, twos = null;
        tmp.next = zero;
        while (head != null) {
            if (head.data == 0) {
                if (zero == null) {
                    zero = head;
                    tmp = zero;
                } else {
                    zero.next = head;
                    zero = zero.next;
                }
            } else if (head.data == 1) {
                if (ones == null) {
                    ones = head;
                } else {
                    ones.next = head;
                    ones = ones.next;
                }
            } else {
                if (twos == null) {
                    twos = head;
                } else {
                    twos.next = head;
                    twos = twos.next;
                }
            }
            head = head.next;
        }
        merge(zero, ones);
        merge(ones, twos);

        return tmp.next;
    }

    private static void merge(Node left, Node right) {
        if (left != null) {
            left.next = right;
        }
    }

    public static void main(String[] args) {

    }
}
