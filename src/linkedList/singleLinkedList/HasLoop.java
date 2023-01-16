package linkedList.singleLinkedList;

public class HasLoop {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        do{
            if(slow == null || slow.next == null){
                return false;
            }
            slow = slow.next;
            if(fast == null|| fast.next == null || fast.next.next == null){
                return false;
            }
            fast = fast.next.next;
        }while(slow!=fast);
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasCycle(new ListNode(3).insertToEnd(2).insertToEnd(0).insertToEnd(-4).insertLoopAtIndex(1)));

    }
}
