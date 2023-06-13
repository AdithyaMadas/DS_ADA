package heaps.redo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.function.IntConsumer;

public class ShortestJobFirst {
    static int solve(int bt[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : bt) {
            pq.offer(i);
        }
        int waitTime = 0;
        while (!pq.isEmpty()) {
            waitTime += pq.poll();
        }
        return waitTime / bt.length;
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{4, 3, 7, 1, 2}));
    }
}
