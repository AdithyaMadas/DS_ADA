package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MinMultiplicationsToReachEnd {
    static int minimumMultiplications(int[] arr, int start, int end) {
        boolean[] vis = new boolean[100000];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == end) {
                return poll[1];
            }
            for (int i : arr) {
                int index = (i * poll[0]) % 100000;
                if (!vis[index]) {
                    vis[index] = true;
                    queue.offer(new int[]{index, poll[1] + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minimumMultiplications(new int[]{256}, 1, 13));
    }
}
