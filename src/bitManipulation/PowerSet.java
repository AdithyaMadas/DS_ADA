package bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            List<Integer> l = new ArrayList<>();
            for (int bit = 0; bit < nums.length; bit++) {
                if ((i & (1 << bit)) != 0) {
                    l.add(nums[bit]);
                }
            }
            list.add(l);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
