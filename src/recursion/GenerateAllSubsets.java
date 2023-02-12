package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsets {
    public static List<List<Integer>> subsets(int[] nums) {
        return helper(nums, 0);
    }

    private static List<List<Integer>> helper(int[] nums, int currCount) {
        if (nums.length == currCount) {
            return new ArrayList<List<Integer>>(){{
                add(new ArrayList<>());
            }};
        }
        List<List<Integer>> helper = helper(nums, currCount + 1);
        List<List<Integer>> res = new ArrayList<>(helper);
        for (List<Integer> i : helper) {
            List<Integer> newList = new ArrayList<>(i);
            newList.add(nums[currCount]);
            res.add(newList);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
