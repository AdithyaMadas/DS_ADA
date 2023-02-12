package linkedList.singleLinkedList;

public class Cycle2 {
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head, index = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != index) {
                    slow = slow.next;
                    index = index.next;
                }
                return index;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        node.next.next.next.next = node.next;
        System.out.println(detectCycle(node).val);

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = node1;

        System.out.println(detectCycle(node1).val);
    }
}
