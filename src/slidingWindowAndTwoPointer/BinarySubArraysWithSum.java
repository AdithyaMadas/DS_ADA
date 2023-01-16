package slidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArraysWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : nums) {
            sum += i;
            if (map.containsKey(sum - goal)) {
                res += map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{0,0,0,0,0}, 0));
    }
}
