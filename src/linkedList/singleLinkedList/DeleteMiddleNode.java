package linkedList.singleLinkedList;

public class DeleteMiddleNode {
    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        System.out.println(deleteMiddle(ListNode.createFromList(new int[]{1})));
    }
}
