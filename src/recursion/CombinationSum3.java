package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(k, n, list, new ArrayList<>(), 1);
        return list;
    }

    private static void helper(int k, int target, List<List<Integer>> l, ArrayList<Integer> list, int curr) {
        if (target == 0 && list.size() == k) {
            l.add(new ArrayList<>(list));
        }
        if (target < 0 || curr == 10 || list.size() > k) {
            return;
        }
        for (int i = curr; i <= 9; i++) {
            if (i > target) {
                break;
            }
            list.add(i);
            helper(k, target - i, l, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(4, 1));
        System.out.println(combinationSum3(9, 45));
    }
}
