package linkedList.singleLinkedList;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null || head.next==null){return null;}
        ListNode start = new ListNode(0);
        ListNode forward = start;
        forward.next = head;
        while (n-- >= 0) {
            forward = forward.next;
        }
        ListNode toDelete = start;
        while (forward!=null) {
            forward = forward.next;
            toDelete = toDelete.next;
        }
        toDelete.next = toDelete.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        System.out.println(removeNthFromEnd(ListNode.createFromList(new int[]{1,2,3,4,5}), 1));
    }
}
