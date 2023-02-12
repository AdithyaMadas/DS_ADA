package dailyChallenge;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDistance {

//    public static int maxDistance(int[][] grid) {
//        Queue<int[]> queue = new LinkedList<>();
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    queue.add(new int[]{i - 1, j});
//                    queue.add(new int[]{i + 1, j});
//                    queue.add(new int[]{i, j - 1});
//                    queue.add(new int[]{i, j + 1});
//                }
//            }
//        }
//        return getMaxDistance(grid, queue);
//    }
//
//    private static int getMaxDistance(int[][] grid, Queue<int[]> queue) {
//        int dis = -1;
//        while (!queue.isEmpty()) {
//            dis++;
//            Queue<int[]> queue1 = new LinkedList<>();
//            while (!queue.isEmpty()) {
//                int[] poll = queue.poll();
//                addAdjacentWaterToQueue(grid, poll, queue1);
//            }
//            queue = queue1;
//        }
//        return dis == 0 ? -1 : dis;
//    }
//
//    private static void addAdjacentWaterToQueue(int[][] grid, int[] poll, Queue<int[]> queue) {
//        if (poll[0] >= 0 && poll[0] < grid.length && poll[1] >= 0 && poll[1] < grid[0].length) {
//            if (grid[poll[0]][poll[1]] == 0) {
//                grid[poll[0]][poll[1]] = 1;
//                int i = poll[0];
//                int j = poll[1];
//                queue.add(new int[]{i - 1, j});
//                queue.add(new int[]{i + 1, j});
//                queue.add(new int[]{i, j - 1});
//                queue.add(new int[]{i, j + 1});
//            }
//        }
//    }


    static class DistanceNode{
        int[] nodes;

        public DistanceNode(int[] nodes) {
            this.nodes = nodes;
        }
    }

    public static int maxDistance(int[][] grid) {
        Queue<DistanceNode> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new DistanceNode(new int[]{i, j}));
                }
            }
        }
        return getMaxDistance(grid, queue);
    }

    private static int getMaxDistance(int[][] grid, Queue<DistanceNode> queue) {
        int max = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            max++;
            for (int i = 0; i < size; i++) {
                DistanceNode poll = queue.poll();
                addAdjacentWaterToQueue(grid, poll, queue);
//                grid[poll.nodes[0]][poll.nodes[1]] = 1;
            }
        }
        return max == 0 ? -1 : max;
    }

    private static void addAdjacentWaterToQueue(int[][] grid, DistanceNode poll, Queue<DistanceNode> queue) {
        if (poll.nodes[0] != 0) {
            if (grid[poll.nodes[0] - 1][poll.nodes[1]] == 0) {
                grid[poll.nodes[0] - 1][poll.nodes[1]] = 1;
                queue.add(new DistanceNode(new int[]{poll.nodes[0] - 1, poll.nodes[1]}));
            }
        }
        if (poll.nodes[0] != grid.length - 1) {
            if (grid[poll.nodes[0] + 1][poll.nodes[1]] == 0) {
                grid[poll.nodes[0] + 1][poll.nodes[1]] = 1;
                queue.add(new DistanceNode(new int[]{poll.nodes[0] + 1, poll.nodes[1]}));
            }
        }
        if (poll.nodes[1] != 0) {
            if (grid[poll.nodes[0]][poll.nodes[1] - 1] == 0) {
                grid[poll.nodes[0]][poll.nodes[1] - 1] = 1;
                queue.add(new DistanceNode(new int[]{poll.nodes[0], poll.nodes[1] - 1}));
            }
        }
        if (poll.nodes[1] != grid[0].length - 1) {
            if (grid[poll.nodes[0]][poll.nodes[1] + 1] == 0) {
                grid[poll.nodes[0]][poll.nodes[1] + 1] = 1;
                queue.add(new DistanceNode(new int[]{poll.nodes[0], poll.nodes[1] + 1}));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}));
        System.out.println(maxDistance(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println(maxDistance(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        System.out.println(maxDistance(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}));
    }
}
