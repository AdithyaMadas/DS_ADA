package linkedList.singleLinkedList;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode middle = findMiddle(head);
        middle.next = reverseLinkedList(middle.next);
        middle = middle.next;
        ListNode start = head;
        while (middle != null) {
            if (middle.val != start.val) {
                return false;
            }
            middle = middle.next;
            start = start.next;
        }
        return true;
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (true) {
            if (fast == null || fast.next == null || fast.next.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode(1).insertToEnd(2).insertToEnd(2).insertToEnd(1)));
    }
}
