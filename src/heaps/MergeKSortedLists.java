package heaps;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode l : lists) {
            while (l.next != null) {
                queue.offer(l.val);
                l = l.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            ListNode newNode = new ListNode(queue.poll());
            tail.next = newNode;
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
