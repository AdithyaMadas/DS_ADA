package stacksAndQueues;

import java.util.ArrayDeque;

public class RottingOranges {

    static class Pair{
        int i, j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public static int orangesRotting(int[][] grid) {
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        int rotten = 0, fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    rotten++;
                    stack.push(new Pair(i, j));
                }
            }
        }
        if(rotten==0) return -1;
        int time = 0;
        while (!stack.isEmpty() && fresh > 0) {
            int len = stack.size();
            int[][] directions = new int[][]{
                    {0, 1}, {0, -1}, {1, 0}, {-1, 0}
            };
            while (len-- > 0) {
                Pair pair = stack.removeLast();
                int r = pair.i, c = pair.j;
                for (int[] dir : directions) {
                    int dr = dir[0] + r, dc = dir[1] + c;
                    if (dr < grid.length && dr >= 0 &&
                            dc < grid[0].length && dc >= 0 && grid[dr][dc] == 1) {
                        grid[dr][dc] = 2;
                        fresh--;
                        stack.push(new Pair(dr, dc));
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]
                {{2,0}}));
    }
}
