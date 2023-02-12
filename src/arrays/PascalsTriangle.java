package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        lists.add(list);
        if (numRows == 1) {
            return lists;
        }
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = lists.get(i - 1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            for (int j = 1; j < i; j++) {
                currRow.add(j, prevRow.get(j - 1) + prevRow.get(j));
            }
            currRow.add(1);
            lists.add(currRow);
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(generate(7));
    }
}
