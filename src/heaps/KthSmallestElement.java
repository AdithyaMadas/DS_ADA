package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : arr) {
            queue.offer(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[]{7, 10, 4, 20, 15}, 0, 0, 4));
    }
}
