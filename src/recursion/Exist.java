package recursion;

public class Exist {
    public static boolean exist(char[][] board, String word) {
        if(word.length()==0) return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean check(char[][] board, int i, int j, String word) {
        if (word.charAt(0) != board[i][j]) {
            return false;
        }
        word = word.substring(1);
        if (word.length() == 0) {
            return true;
        }
        char c = board[i][j];
        board[i][j] = '$';
        if (i > 0) {
            if (check(board, i - 1, j, word)) {
                return true;
            }
        }
        if (i < board.length - 1) {
            if (check(board, i + 1, j, word)) {
                return true;
            }
        }
        if (j > 0) {
            if (check(board, i, j - 1, word)) {
                return true;
            }
        }
        if (j < board[0].length - 1) {
            if (check(board, i, j + 1, word)) {
                return true;
            }
        }
        board[i][j] = c;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(exist(new char[][]{
                {'A'}
        }, ""));
    }
}
