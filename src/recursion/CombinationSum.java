package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {
        if (remain < 0) return; /** no solution */
        else if (remain == 0) list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < cand.length; i++) {
                tempList.add(cand[i]);
                backtrack(list, tempList, cand, remain - cand[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> list = new ArrayList<>();
//        helper(candidates, list, 0, target, new ArrayList<>());
//        return list;
//    }
//
//    private static void helper(int[] candidates, List<List<Integer>> ans, int index, int target, List<Integer> list) {
//        if (target < 0 || index == candidates.length) {
//            return;
//        }
//        if (target == 0) {
//            ans.add(new ArrayList<>(list));
//            return;
//        }
//        if (target >= candidates[index]) {
//            list.add(candidates[index]);
//            helper(candidates, ans, index, target - candidates[index], list);
//            list.remove(list.size() - 1);
//        }
//        helper(candidates, ans, index + 1, target,list);
//    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(combinationSum(new int[]{8, 7, 4, 3}, 11));
        System.out.println(combinationSum(new int[]{1, 2, 3}, 5));
    }
}
