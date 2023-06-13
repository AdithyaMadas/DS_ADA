package graphs;

import java.util.*;

public class MinSpanningTree {

    static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static int spanningTree(int V, int E, int edges[][]) {
        Map<Integer, List<Edge>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], (v) -> new ArrayList<>()).add(new Edge(edge[1], edge[2]));
            map.computeIfAbsent(edge[1], (v) -> new ArrayList<>()).add(new Edge(edge[0], edge[2]));
        }

        // 0-> weight, 1-> to
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        boolean[] vis = new boolean[V];
        priorityQueue.offer(new int[]{0, 0});
        int cost = 0;
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            if(vis[poll[1]]) continue;
            cost += poll[0];
            vis[poll[1]] = true;
            for (Edge e : map.getOrDefault(poll[1], new ArrayList<>())) {
                priorityQueue.offer(new int[]{e.weight, e.to});
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        System.out.println(spanningTree(3, 3, new int[][]{{0, 1, 5}, {1, 2, 3}, {0, 2, 1}}));
    }
}
