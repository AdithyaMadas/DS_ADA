package linkedList.singleLinkedList;

public class OddEvenList {
    public static ListNode oddEvenList(ListNode head) {
        if(head == null){return null;}
        ListNode odd = head, even = head.next;
        while (true) {
            if (even == null || even.next == null) {
                break;
            }
            ListNode nextOddNode = even.next;
            even.next = nextOddNode.next;
            nextOddNode.next = odd.next;
            odd.next = nextOddNode;
            odd = odd.next;
            even = even.next;
        }
        return head;
    }

    public static void main(String[] args) {
//        System.out.println(oddEvenList(new ListNode(1).insertToEnd(2).insertToEnd(3).insertToEnd(4).insertToEnd(5)));
        System.out.println(oddEvenList(ListNode.createFromList(new int[]{2, 1, 3, 5, 6, 4, 7})));

    }
}
