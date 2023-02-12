package linkedList.singleLinkedList;

public class OddEven {
    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = head, even = head.next;
        while (even != null && even.next != null) {
            ListNode nextOdd = even.next;
            even.next = nextOdd.next;
            nextOdd.next = odd.next;
            odd.next = nextOdd;
            even = even.next;
            odd = odd.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(oddEvenList(ListNode.createFromList(new int[]{1, 2, 3, 4, 5})));
        System.out.println(oddEvenList(ListNode.createFromList(new int[]{2, 1, 3, 5, 6, 4, 7})));
    }
}
