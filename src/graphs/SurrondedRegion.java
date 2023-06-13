package graphs;

import java.util.Arrays;

public class SurrondedRegion {
    public static void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, i, board[0].length - 1);
            }
        }

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board, board.length - 1, i);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'Q') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        board[i][j] = 'Q';
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length && board[newI][newJ] == 'O') {
                dfs(board, newI, newJ);
            }
        }
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}};
//        char[][] chars = {{'X', 'O', 'X'}, { 'O', 'X', 'O'}, {'X', 'O', 'X'}};
        solve(chars);
        System.out.println(Arrays.deepToString(chars));
    }
}
