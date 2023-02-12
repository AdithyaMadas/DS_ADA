package linkedList.singleLinkedList;

public class Reverse {

    public static ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    private static ListNode reverse(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }
        ListNode next = curr.next;
        curr.next = prev;
        return reverse(next, curr);
    }

//    public static ListNode reverseList(ListNode head) {
//        ListNode curr = head, prev = null;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;
//    }

    public static void main(String[] args) {
        System.out.println(reverseList(ListNode.createFromList(new int[]{1, 2, 3, 4, 5})));
        System.out.println(reverseList(ListNode.createFromList(new int[]{1, 2})));
    }
}
