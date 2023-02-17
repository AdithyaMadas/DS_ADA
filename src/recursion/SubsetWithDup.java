package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDup {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, list, new ArrayList<Integer>(), 0);
        return list;
    }

    private static void helper(int[] nums, List<List<Integer>> list, ArrayList<Integer> curr, int index) {
        list.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            if(i!=index && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            helper(nums, list, curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2}));
    }
}
