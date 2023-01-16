package linkedList.singleLinkedList;

public class DetectIndexOfLoop {

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        ListNode entry = head;
        while (entry != slow) {
            slow = slow.next;
            entry = entry.next;
        }
        return entry;
    }

    public static void main(String[] args) {
        System.out.println(detectCycle(new ListNode(3).insertToEnd(2).insertToEnd(0).insertToEnd(-4).insertLoopAtIndex(1)).val);
    }
}
