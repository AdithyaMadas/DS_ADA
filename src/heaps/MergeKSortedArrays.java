package heaps;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] i : arr) {
            for (int j : i) {
                queue.offer(j);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < K * K; i++) {
            arrayList.add(queue.poll());
        }
        return arrayList;
    }

    public static void main(String[] args) {
        System.out.println(mergeKArrays(new int[][]{{1, 2, 3, 4}, {2, 2, 3, 4},
                {5, 5, 6, 6}, {7, 8, 9, 9}}, 4));
    }
}
