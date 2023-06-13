package graphs;

import java.util.*;

public class CheapestFlightWithKStops {

    static class Path {
        int dest;
        int cost;

        public Path(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] min = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);

        min[src] = 0;

        Map<Integer, List<Path>> map = new HashMap<>();

        for (int[] i : flights) {
            map.computeIfAbsent(i[0], (v) -> new ArrayList<>()).add(new Path(i[1], i[2]));
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, src});
        // 0 -> stops, 1 -> currCost, 2 -> currNode

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == k + 1) {
                break;
            }
            for (Path p : map.getOrDefault(poll[2], new ArrayList<>())) {
                if (min[p.dest] > poll[1] + p.cost) {
                min[p.dest] = poll[1] + p.cost;
                queue.offer(new int[]{poll[0] + 1, poll[1] + p.cost, p.dest});
                }
            }
        }

        return min[dst] == Integer.MAX_VALUE ? -1 : min[dst];
    }




//    static class Path {
//        int dest;
//        int cost;
//
//        public Path(int dest, int cost) {
//            this.dest = dest;
//            this.cost = cost;
//        }
//    }
//
//    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        int[][] min = new int[k + 2][n];
//        for (int[] i : min) {
//            Arrays.fill(i, Integer.MAX_VALUE);
//        }
//
//        Map<Integer, List<Path>> map = new HashMap<>();
//
//        for (int[] i : flights) {
//            map.computeIfAbsent(i[0], (v) -> new ArrayList<>()).add(new Path(i[1], i[2]));
//        }
//
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
//            }
//        });
//        priorityQueue.offer(new int[]{src, 0, 0});
//        // 0 -> currNode, 1 -> cost, 2-> stops
//        while (!priorityQueue.isEmpty()) {
//            int[] poll = priorityQueue.poll();
//            if (poll[0] == dst) {
//                return poll[1];
//            }
//            if (poll[2] == k + 1) {
//                continue;
//            }
//            for (Path p : map.getOrDefault(poll[0], new ArrayList<>())) {
//                if (poll[1] + p.cost < min[poll[2] + 1][p.dest]) {
//                    min[poll[2] + 1][p.dest] = poll[1] + p.cost;
//                    priorityQueue.offer(new int[]{p.dest, poll[1] + p.cost, poll[2] + 1});
//                }
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        System.out.println(findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1));
        System.out.println(findCheapestPrice(5, new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}}, 0, 2, 2));
    }
}
