package heaps;

import java.util.PriorityQueue;

public class KthLargestInStream {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargestInStream(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }
}
