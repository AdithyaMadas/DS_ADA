package arrays;

import java.util.HashMap;
import java.util.Map;

public class subArraySum {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int currSum = 0;
        int res = 0;
        for (int i : nums) {
            currSum += i;
            res += map.getOrDefault(currSum - k, 0);
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }
}
