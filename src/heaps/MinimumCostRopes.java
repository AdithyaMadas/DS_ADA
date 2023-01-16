package heaps;

import java.util.PriorityQueue;

public class MinimumCostRopes {
    static long minCost(long arr[], int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.offer(arr[i]);
        }
        long cost = 0;
        while (pq.size() >= 2) {
            long sum = pq.poll() + pq.poll();
            cost += sum;
            pq.offer(sum);
        }
        return cost;
    }

    public static void main(String[] args) {
        System.out.println(minCost(new long[]{2,2,3}, 3));
    }
}
