package dailyChallenge;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumsDivisibleByK {
    public static int subarraysDivByK(int[] nums, int k) {
        int res = 0, prefixSum = 0;
        int[] map = new int[k];
        map[0] = 1;
        for (int i : nums) {
            prefixSum += i;
            int rem = prefixSum % k;
            if (rem < 0) {
                rem = k + rem;
            }
            res += map[rem];
            map[rem]++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));
    }
}
