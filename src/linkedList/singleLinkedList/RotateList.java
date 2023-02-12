package linkedList.singleLinkedList;

import java.util.WeakHashMap;

public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null) return null;
        ListNode curr = head;
        int len = getLen(head, 0);
        if(len==1) return head;
        k = len > k ? len - k : len - k % len;
        if(k==0||k==len) return head;
        while (k-- > 1) {
            if (curr.next == null) {
                curr = head;
            } else {
                curr = curr.next;
            }
        }
        ListNode next = curr.next;
        curr.next = null;
        curr = next;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        head = next;
        return head;
    }

    private static int getLen(ListNode head, int currLen) {
        if (head== null) {
            return currLen;
        }
        return getLen(head.next, currLen + 1);
    }

    public static void main(String[] args) {
        System.out.println(rotateRight(ListNode.createFromList(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println(rotateRight(ListNode.createFromList(new int[]{1, 2, 3, 4, 5}), 3));
        System.out.println(rotateRight(ListNode.createFromList(new int[]{1, 2}), 0));
    }
}
