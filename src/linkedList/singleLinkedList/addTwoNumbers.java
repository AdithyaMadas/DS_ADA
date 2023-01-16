package linkedList.singleLinkedList;

public class addTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode head = tmp;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            tmp.next = new ListNode(sum % 10);
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carry;
            tmp.next = new ListNode(sum % 10);
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            tmp = tmp.next;
            l1 = l1.next;
        }


        while (l2 != null) {
            int sum = l2.val + carry;
            tmp.next = new ListNode(sum % 10);
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            tmp = tmp.next;
            l2 = l2.next;
        }

        if(carry==1) tmp.next = new ListNode(1);
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(
                addTwoNumbers(
                        ListNode.createFromList(new int[]{9,9,9,9,9,9,9}),
                        ListNode.createFromList(new int[]{9,9,9,9})));

    }
}
