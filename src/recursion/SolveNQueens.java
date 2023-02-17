package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolveNQueens {

    static class Solution {

        List<List<String>> result;
        boolean[] cols;
        boolean[] ndiag;
        boolean[] rdiag;

        public List<List<String>> solveNQueens(int n) {

            result = new ArrayList<>();

            cols = new boolean[n];
            ndiag = new boolean[2*n-1];
            rdiag = new boolean[2*n-1];

            char[][] state = new char[n][n];

            for(char[] rows : state) Arrays.fill(rows, '.');

            solve(state, 0, n);

            return result;
        }

        private void solve(char[][] state, int row, int n) {

            // base condition
            if(row == n) {
                getPositions(state, n);
                return;
            }

            // main logic
            for(int col = 0; col < n; col++ ) {

                boolean isCurrentCellSafe = isSafe(state, row, col, n);

                if(isCurrentCellSafe) {

                    state[row][col] = 'Q';
                    cols[col] = true;
                    ndiag[row-col+n-1] = true;
                    rdiag[row+col] = true;

                    solve(state, row + 1, n);

                    state[row][col] = '.';
                    cols[col] = false;
                    ndiag[row-col+n-1] = false;
                    rdiag[row+col] = false;
                }

            }
        }

        private boolean isSafe(char[][] state, int row, int col, int n) {

            if(cols[col] == false  // is this position not filled
                    && ndiag[row-col+n-1] == false && rdiag[row+col] == false) {
                return true;
            }
            return false;
        }

        private void getPositions(char[][] state, int n) {

            ArrayList<String> temp = new ArrayList<>();

            for(char[] row : state) {
                StringBuilder s = new StringBuilder();
                for(int i=0;i<n;i++) {
                    s.append(row[i]);
                }
                temp.add(s.toString());
            }

            result.add(temp);
        }
    }


    // My solution
//    public static List<List<String>> solveNQueens(int n) {
//        List<List<String>> res = new ArrayList<>();
//        int[][] c = new int[n][n];
//        generate(res, c, 0, n, new ArrayList<>());
//        return res;
//    }
//
//    private static void generate(List<List<String>> res, int[][] c, int currRow, int n, ArrayList<String> currList) {
//        if (currRow == n) {
//            res.add(new ArrayList<>(currList));
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if (c[currRow][i] != 0) {
//                continue;
//            }
//            fillAllQueen(c, currRow, i);
//            String s = String.join("", Collections.nCopies(i, ".")) + "Q" + String.join("", Collections.nCopies(n - i - 1, "."));
//            currList.add(s);
//            generate(res, c, currRow + 1, n, currList);
//            currList.remove(currList.size() - 1);
//            removeAllQueen(c, currRow, i);
//        }
//    }
//
//    private static void fillAllQueen(int[][] c, int row, int col) {
//        for (int i = 0; i < c[0].length; i++) {
//            if (c[i][col] == 0) {
//                c[i][col] = row + 1;
//            }
//        }
//        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
//            if (c[i][j] == 0) {
//                c[i][j] = row + 1;
//            }
//        }
//        for (int i = row, j = col; i < c.length && j < c.length; i++, j++) {
//            if (c[i][j] == 0) {
//                c[i][j] = row + 1;
//            }
//        }
//        for (int i = row, j = col; i < c.length && j >= 0; i++, j--) {
//            if (c[i][j] == 0) {
//                c[i][j] = row + 1;
//            }
//        }
//        for (int i = row, j = col; i >= 0 && j < c.length; i--, j++) {
//            if (c[i][j] == 0) {
//                c[i][j] = row + 1;
//            }
//        }
//    }
//
//    private static void removeAllQueen(int[][] c, int row, int col) {
//        for (int i = 0; i < c[0].length; i++) {
//            if (c[i][col] == row+1) {
//                c[i][col] = 0;
//            }
//        }
//        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
//            if (c[i][j] == row+1) {
//                c[i][j] = 0;
//            }
//        }
//        for (int i = row, j = col; i < c.length && j < c.length; i++, j++) {
//            if (c[i][j] == row+1) {
//                c[i][j] = 0;
//            }
//        }
//        for (int i = row, j = col; i < c.length && j >= 0; i++, j--) {
//            if (c[i][j] == row+1) {
//                c[i][j] = 0;
//            }
//        }
//        for (int i = row, j = col; i >= 0 && j < c.length; i--, j++) {
//            if (c[i][j] == row+1) {
//                c[i][j] = 0;
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }
}
