package dailyChallenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequences {
    public static List<List<Integer>> findSubsequences(int[] nums) {
        double max = Math.pow(2, nums.length);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 3; i < max; i++) {
            List<Integer> currSeq = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    currSeq.add(nums[j]);
                }
            }
            if (currSeq.size() >= 2) {
                if (isIncreasingSeq(currSeq)) {
                    set.add(currSeq);
                }
            }
        }
        return new ArrayList<>(set);
    }

    private static boolean isIncreasingSeq(List<Integer> currSeq) {
        int prev = currSeq.get(0);
        for (int i = 1; i < currSeq.size(); i++) {
            if (currSeq.get(i) < prev) {
                return false;
            }
            prev = currSeq.get(i);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findSubsequences(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));
    }
}
