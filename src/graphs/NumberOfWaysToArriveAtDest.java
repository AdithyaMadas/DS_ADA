package graphs;

import java.util.*;

public class NumberOfWaysToArriveAtDest{

    static class Path implements Comparable<Path>{
        int to, cost;

        public Path(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Path o) {
            return this.cost - o.cost;
        }
    }
    public static int countPaths(int n, int[][] roads) {
        if(n==1) return 1;
        long[] min = new long[n];
        int[] count = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[0] = 0;
        count[0] = 1;
        Map<Integer, ArrayList<int[]>> map = new HashMap<>();
        for (int[] road : roads) {
            map.computeIfAbsent(road[0], (v) -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            map.computeIfAbsent(road[1], (v) -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }
        Queue<Path> priorityQueue = new LinkedList<>();

        // 0-> weight, 1 -> node
        priorityQueue.offer(new Path(0,0));

        while (!priorityQueue.isEmpty()) {
            Path poll = priorityQueue.poll();
            for (int[] path : map.get(poll.to)) {
                if (path[1] + poll.cost < min[path[0]]) {
                    min[path[0]] = path[1] + poll.cost;
                    count[path[0]] = count[poll.to] % 1000000007;
                    priorityQueue.offer(new Path(path[0], path[1] + poll.cost));
                } else if (path[1] + poll.cost == min[path[0]]) {
                    count[path[0]] = (count[path[0]] + count[poll.to]) % 1000000007;
                }
            }
        }

        return (count[n - 1] % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(countPaths(7, new int[][]{{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}}));
    }
}
