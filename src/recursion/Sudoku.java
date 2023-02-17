package recursion;

import java.util.Arrays;
import java.util.HashSet;

public class Sudoku {
    public static void solveSudoku(char[][] board) {
        HashSet<Character>[] col = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            col[i] = new HashSet<>();
        }
        HashSet<Character>[] row = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
        }
        HashSet<Character>[][] box = new HashSet[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                box[i][j] = new HashSet<>();
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    col[j].add(board[i][j]);
                    row[i].add(board[i][j]);
                    box[i / 3][j / 3].add(board[i][j]);
                }
            }
        }
        generate(board, col, row, box, 0, 0);
    }

    private static boolean generate(char[][] board, HashSet<Character>[] col, HashSet<Character>[] row, HashSet<Character>[][] box, int rowNumber, int colNumber) {
        if (rowNumber == 9) {
            return true;
        }
        if (board[rowNumber][colNumber] != '.') {
            if(colNumber==8) {
                return generate(board, col, row, box, rowNumber + 1, 0);
            } else {
                return generate(board, col, row, box, rowNumber, colNumber + 1);
            }
        }
        else {
            for (char q = '1'; q <= '9'; q++) {
                if (!col[colNumber].contains(q) && !row[rowNumber].contains(q) && !box[rowNumber / 3][(colNumber) / 3].contains(q)) {
                    col[colNumber].add(q);
                    row[rowNumber].add(q);
                    box[rowNumber / 3][(colNumber) / 3].add(q);
                    board[rowNumber][colNumber] = q;
                    if(colNumber==8) {
                        if(generate(board, col, row, box, rowNumber + 1, 0)){
                            return true;
                        }
                    } else {
                        if (generate(board, col, row, box, rowNumber, colNumber + 1)) {
                            return true;
                        }
                    }
                    col[colNumber].remove(q);
                    row[rowNumber].remove(q);
                    box[rowNumber / 3][(colNumber) / 3].remove(q);
                    board[rowNumber][colNumber] = '.';
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(chars);
        System.out.println(Arrays.deepToString(chars));
    }
}
