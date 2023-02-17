package recursion;

import java.util.*;

public class CobinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> l = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, l, target, 0, new ArrayList<>());
        return l;
    }

    private static void helper(int[] candidates, List<List<Integer>> l, int target, int index, List<Integer> list) {
        if (target == 0) {
            l.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || index == candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if(i!=index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i] > target) break;

            list.add(candidates[i]);
            helper(candidates, l, target - candidates[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}
