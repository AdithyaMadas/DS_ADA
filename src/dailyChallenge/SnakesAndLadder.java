package dailyChallenge;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadder {

    public static int snakesAndLadders(int[][] board) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int n = board.length;
        for (int moves = 0; !queue.isEmpty(); moves++) {
            for (int q = queue.size(); q > 0; q--) {
                Integer poll = queue.poll();
                boolean needToCheck = true;
                for (int i = 6; i >= 1; i--) {
                    int x = getBoardValue(board, poll + i, n);
                    if (x == poll + i) {
                        if (needToCheck) {
                            needToCheck = false;
                            queue.offer(x);
                        }
                    } else {
                        if (x == n * n) {
                            return moves + 1;
                        } else if (x > poll + i) {
                            queue.offer(x);
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static int getBoardValue(int[][] board, int num, int n) {
        int r = (num - 1) / n;
        int x = n - 1 - r;
        int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
        return board[x][y];
    }

    public static void main(String[] args) {
        System.out.println(snakesAndLadders(new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}}));
        System.out.println(snakesAndLadders(new int[][]{{-1, -1}, {-1, 3}}));
        System.out.println(snakesAndLadders(new int[][]{{-1, 15, 9, 1, -1}, {-1, -1, 10, 5, 19}, {18, -1, 23, 9, -1}, {1, 13, -1, 16, 20}, {-1, 10, 10, 25, 13}}));
//        System.out.println(snakesAndLadders(new int[][]{{-1, 1, 2, -1}, {2, 13, 15, -1}, {-1, 10, -1, -1}, {-1, 6, 2, 8}}));

    }
}
