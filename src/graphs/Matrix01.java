package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    static class Pair{
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public static int[][] updateMatrix(int[][] mat) {
        int[][] dis = new int[mat.length][mat[0].length];
        for (int[] i : dis) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    dis[i][j] = 0;
                    queue.add(new Pair(i, j));
                }
            }
        }
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            for (int[] direction : dir) {
                int i = poll.i + direction[0];
                int j = poll.j + direction[1];
                if (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length) {
                    if (dis[poll.i][poll.j] + 1 < dis[i][j]) {
                        dis[i][j] = dis[poll.i][poll.j] + 1;
                        queue.add(new Pair(i, j));
                    }
                }
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(updateMatrix(new int[][]
                {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}
        )));
    }
}
