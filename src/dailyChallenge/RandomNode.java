package dailyChallenge;

import java.util.Random;

public class RandomNode {
    class Solution {

        public class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

//        int size;
//        ListNode head;
//        Random random;
//
//        public Solution(ListNode head) {
//            this.head = head;
//            getSize();
//            random = new Random();
//        }
//
//        private void getSize() {
//            ListNode index = head;
//            size = 0;
//            while (index != null) {
//                index = index.next;
//                size++;
//            }
//        }
//
//        public int getRandom() {
//            ListNode index = head;
//            int randInt = random.nextInt(size);
//            while (randInt-- > 0) {
//                index = index.next;
//            }
//            return index.val;
//        }

        ListNode head;
        Random random;

        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        public int getRandom() {
            int ans = 0, i = 1;
            ListNode itr = head;
            while (itr != null) {
                if(random.nextDouble() * i++ < 1) ans = itr.val;
                itr = itr.next;
            }
            return ans;
        }
    }

    public static void main(String[] args) {

    }
}
