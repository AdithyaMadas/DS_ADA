package linkedList.singleLinkedList;

public class FindLengthOfLoop {
    static int countNodesinLoop(Node head) {
        Node slow = head, fast = head;
        do {
            if (fast == null || fast.next == null) {
                return 0;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        int len = 1;
        slow = slow.next;
        while (fast != slow) {
            slow = slow.next;
            len++;
        }
        return len;
    }

}
