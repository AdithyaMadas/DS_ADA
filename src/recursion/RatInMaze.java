package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RatInMaze {

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        generate(res, 0, 0, m, new LinkedList<String>());
        return res;
    }

    private static void generate(ArrayList<String> res, int i, int j, int[][] m, LinkedList<String> currPath) {
        if (i < 0 || i >= m.length || j < 0 || j >= m.length) {
            return;
        }
        if (m[i][j] == 0) {
            return;
        }
        if (i == m.length - 1 && j == m.length - 1) {
            res.add(generateString(currPath));
            return;
        }
        m[i][j] = 0;
        currPath.addLast("U");
        generate(res, i - 1, j, m, currPath);
        currPath.removeLast();
        currPath.addLast("D");
        generate(res, i + 1, j, m, currPath);
        currPath.removeLast();
        currPath.addLast("L");
        generate(res, i, j - 1, m, currPath);
        currPath.removeLast();
        currPath.addLast("R");
        generate(res, i, j + 1, m, currPath);
        currPath.removeLast();
        m[i][j] = 1;
    }

    private static String generateString(LinkedList<String> currPath) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : currPath) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(findPath(new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}}, 4));
    }
}
