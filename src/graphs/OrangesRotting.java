package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting {

    static class Pair {
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public static int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }
        int steps = 0;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair poll = queue.poll();
                for (int[] direction : directions) {
                    int i1 = poll.i + direction[0];
                    int j1 = poll.j + direction[1];
                    if (i1 >= 0 && i1 < grid.length &&
                            j1 >= 0 && j1 < grid[0].length &&
                            grid[i1][j1] == 1) {
                        fresh--;
                        grid[i1][j1] = 2;
                        queue.add(new Pair(i1, j1));
                    }
                }
            }
            steps++;
        }

        return fresh == 0 ? steps : -1;
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
}
