package linkedList.singleLinkedList;

public class SortList {
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = head;
        ListNode right = findMiddle(head);
        ListNode tmp = right.next;
        right.next = null;
        right = tmp;

        left = sortList(left);
        right = sortList(right);

        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode tmp = new ListNode(0);
        ListNode head = tmp;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tmp.next = left;
                tmp = tmp.next;
                left = left.next;
            } else {
                tmp.next = right;
                tmp = tmp.next;
                right = right.next;
            }
        }

        while (left != null) {
            tmp.next = left;
            tmp = tmp.next;
            left = left.next;
        }

        while (right != null) {
            tmp.next = right;
            tmp = tmp.next;
            right = right.next;
        }
        return head.next;
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(sortList(ListNode.createFromList(new int[]{-1, 5, 3, 4, 0})));
    }
}
