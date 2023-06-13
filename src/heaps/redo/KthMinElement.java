package heaps.redo;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthMinElement {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = l; i < r; i++) {
            pq.offer(arr[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[]{7, 10, 4, 3, 20, 15}, 0, 6, 3));
    }
}
