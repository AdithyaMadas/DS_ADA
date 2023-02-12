package linkedList.singleLinkedList;

public class ReverseKAtATime {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }

    private static ListNode reverse(ListNode begin, ListNode end) {
        ListNode start = begin.next, curr = begin.next, prev = begin;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        start.next = curr;
        return start;
    }


    public static void main(String[] args) {
        System.out.println(reverseKGroup(ListNode.createFromList(new int[]{1, 2, 3, 4, 5, 6, 7, 8}), 2));
        System.out.println(reverseKGroup(ListNode.createFromList(new int[]{1, 2, 3, 4, 5}), 3));
    }
}
