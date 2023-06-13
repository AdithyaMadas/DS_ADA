package heaps.redo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.function.IntConsumer;

public class HandOfStraights {
    public static boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(hand).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                pq.offer(value);
            }
        });

        while (pq.size() != 0) {
            int start = pq.poll();
            for (int i = 1; i < groupSize; i++) {
                if (pq.remove(start + i)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
    }
}
