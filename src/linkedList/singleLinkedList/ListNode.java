package linkedList.singleLinkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode insertToEnd(int x) {
        ListNode curr = traverseTillEnd();
        curr.next = new ListNode(x);
        return this;
    }

    public ListNode insertLoopAtIndex(int index) {
        ListNode last = traverseTillEnd();
        last.next = traverseTillIndex(index);
        return this;
    }

    public ListNode traverseTillEnd() {
        ListNode curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

    public ListNode traverseTillIndex(int index) {
        ListNode curr = this;
        while (index-- > 0) {
            curr = curr.next;
        }
        return curr;
    }

    public static ListNode createFromList(int[] list){
        ListNode node = new ListNode(list[0]);
        for (int i = 1; i < list.length; i++) {
            node.insertToEnd(list[i]);
        }
        return node;
    }

    @Override
    public String toString() {
        return this.val + ((this.next == null) ? "" : " -> " + this.next.toString());
    }
}