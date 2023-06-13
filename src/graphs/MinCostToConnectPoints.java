package graphs;

import java.util.*;

public class MinCostToConnectPoints {

    public static int minCostConnectPoints(int[][] points) {
        boolean[] vis = new boolean[points.length];
        int totalCost = 0;
        for (int i = 0; i < points.length; ) {
            vis[i] = true;
            int minWeight = Integer.MAX_VALUE;
            int minNode = -1;
            for (int j = 0; j < points.length; j++) {
                if (i == j || vis[j]) {
                    continue;
                }
                int weight = getWeight(points[i], points[j]);
                if (minWeight > weight) {
                    minWeight = weight;
                    minNode = j;
                }
            }
            if (minNode == -1) {
                break;
            }
            vis[minNode] = true;
            totalCost += minWeight;
            i = minNode;
        }
        return totalCost;
    }

    private static int getWeight(int[] point, int[] point1) {
        return Math.abs(point[0] - point1[0]) + Math.abs(point[1] - point1[1]);
    }

//    static class Edge{
//        int to, weight;
//
//        public Edge(int to, int weight) {
//            this.to = to;
//            this.weight = weight;
//        }
//    }
//    public static int minCostConnectPoints(int[][] points) {
//        Map<Integer, List<Edge>> map = new HashMap<>();
//        for (int i = 0; i < points.length; i++) {
//            List<Edge> edges = map.getOrDefault(i, new ArrayList<>());
//            for (int j = 0; j < points.length; j++) {
//                if(i==j) continue;
//                edges.add(new Edge(j, computeWeight(points[i], points[j])));
//            }
//            map.put(i, edges);
//        }
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//        boolean[] vis = new boolean[map.size()];
//        priorityQueue.offer(new int[]{0, 0});
//        int cost = 0;
//        while (!priorityQueue.isEmpty()) {
//            int[] poll = priorityQueue.poll();
//            if(vis[poll[1]]) continue;
//            cost += poll[0];
//            vis[poll[1]] = true;
//            for (Edge e : map.getOrDefault(poll[1], new ArrayList<>())) {
//                priorityQueue.offer(new int[]{e.weight, e.to});
//            }
//        }
//        return cost;
//    }
//
//    private static int computeWeight(int[] point, int[] point1) {
//        return Math.abs(point[0] - point1[0]) + Math.abs(point1[1] - point[1]);
//    }

    public static void main(String[] args) {
        System.out.println(minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
    }
}
