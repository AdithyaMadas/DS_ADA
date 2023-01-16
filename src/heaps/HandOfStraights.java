package heaps;

import java.util.*;

public class HandOfStraights {

    static class Card implements Comparable<Card>{
        int value, count;

        public Card(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public int compareTo(Card o) {
            return value - o.value;
        }
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i : hand) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Card> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            pq.offer(new Card(e.getKey(), e.getValue()));
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            int i = 0;
            Set<Card> set = new HashSet<>();
            while (!pq.isEmpty() && i < groupSize) {

                Card card = pq.poll();
                if (!pq.isEmpty() && card.value == pq.peek().value - 1) {

                    if (card.count > 1) {
                        card.count--;
                        set.add(card);
                    }
                }
                i++;
            }
            if (i == groupSize) {
                ans++;
            }
            for (Card c : set) {
                pq.offer(c);
            }
        }
        return pq.size()==0;
    }

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1,2,3,4,5}, 3));
    }
}
