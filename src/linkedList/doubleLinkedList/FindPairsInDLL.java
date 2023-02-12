package linkedList.doubleLinkedList;

import java.util.ArrayList;

public class FindPairsInDLL {

    static class Node
    {
        int data;
        Node next,prev;

        Node(int x){
            data = x;
            next = null;
            prev = null;
        }
    }
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        Node start = head, end = tail(head);
        while (start != end) {
            int sum = start.data + end.data;
            if (sum > target) {
                end = end.prev;
            } else if (sum < target) {
                start = start.next;
            } else {
                Node finalStart = start;
                Node finalEnd = end;
                arrayLists.add(new ArrayList<Integer>() {{
                    add(finalStart.data);
                    add(finalEnd.data);
                }});
                end = end.prev;
            }
        }
        return arrayLists;
    }

    private static Node tail(Node head) {
        if (head.next == null) {
            return head;
        }
        return tail(head.next);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(5);
        node.next.prev = node;
        node.next.next = new Node(6);
        node.next.next.prev = node.next;
        System.out.println(findPairsWithGivenSum(6, node));
    }
}
