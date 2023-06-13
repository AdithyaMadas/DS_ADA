package graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPathInMatrix {

    static class Node implements Comparable<Node> {
        int distance;
        int i, j;

        public Node(int distance, int i, int j) {
            this.distance = distance;
            this.i = i;
            this.j = j;
        }


        @Override
        public int compareTo(Node o) {
            if (o.distance == this.distance) {
                return (o.i + o.j) - (this.i + this.j);
            }
            return this.distance - o.distance;
        }
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Node(0, 0, 0));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        while (!priorityQueue.isEmpty()) {
            Node poll = priorityQueue.poll();
            visited[poll.i][poll.j] = true;
            if (poll.i == grid.length - 1 && poll.j == grid[0].length - 1) {
                return poll.distance + 1;
            }
            for (int[] direction : directions) {
                int i = direction[0] + poll.i;
                int j = direction[1] + poll.j;
                if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && !visited[i][j] && grid[i][j] == 0) {
                    priorityQueue.offer(new Node(poll.distance + 1, i, j));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
        System.out.println(shortestPathBinaryMatrix(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
    }
}
