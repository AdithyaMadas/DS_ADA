package graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinEffortPath {

    static class Path implements Comparable<Path>{
        int maxDifference;
        int i, j;

        public Path(int maxDifference, int i, int j) {
            this.maxDifference = maxDifference;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Path o) {
            return this.maxDifference - o.maxDifference;
        }
    }

    public static int minimumEffortPath(int[][] heights) {
        PriorityQueue<Path> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Path(0, 0, 0));
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] vis = new int[heights.length][heights[0].length];

        for (int[] v : vis) {
            Arrays.fill(v, Integer.MAX_VALUE);
        }

        while (!priorityQueue.isEmpty()) {
            Path poll = priorityQueue.poll();
            if (poll.i == heights.length - 1 && poll.j == heights[0].length - 1) {
                return poll.maxDifference;
            }
            for (int[] dir : directions) {
                int i = poll.i + dir[0];
                int j = poll.j + dir[1];
                if (i >= 0 && i < heights.length && j >= 0 && j < heights[0].length) {
                    int diff = Math.max(Math.abs(heights[poll.i][poll.j] - heights[i][j]), poll.maxDifference);
                    if (diff < vis[i][j]) {
                        vis[i][j] = diff;
                        priorityQueue.offer(new Path(diff, i, j));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minimumEffortPath(new int[][]{{1, 10, 6, 7, 9, 10, 4, 9}}));
    }
}
