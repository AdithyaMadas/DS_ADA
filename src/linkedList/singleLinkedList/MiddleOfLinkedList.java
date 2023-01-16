package linkedList.singleLinkedList;

public class MiddleOfLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (fast.next!=null || fast!=null);
        return slow;
    }

    public static void main(String[] args) {

    }
}
