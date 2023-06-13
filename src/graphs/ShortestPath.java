package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
    public static int[] shortestPath(int[][] edges, int n, int m, int src) {
        int[] min = new int[n];
        Arrays.fill(min, -1);
        ArrayList<Integer>[] arrayLists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            arrayLists[edge[0]].add(edge[1]);
            arrayLists[edge[1]].add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer poll = queue.poll();
                if (vis[poll]) {
                    continue;
                }
                vis[poll] = true;
                if (min[poll] == -1) {
                    min[poll] = step;
                }
                for (int i : arrayLists[poll]) {
                    queue.offer(i);
                }
            }
            step++;
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestPath(new int[][]{{1, 5},
                {1, 6},
                {2, 0},
                {3, 3},
                {4, 0},
                {4, 6},
                {5, 3},
                {5, 4},
                {6, 5},
                {6, 6}}, 7, 10, 4)));

    }
}
