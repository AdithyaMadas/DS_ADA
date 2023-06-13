package arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static int lenOfLongSubarr(int A[], int N, int K) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 0);
        int currSum = 0, maxLen = 0;
        for (int i = 0; i < N; i++) {
            currSum += A[i];
            if (preSum.containsKey(currSum - K)) {
                maxLen = Math.max(maxLen, i - preSum.get(currSum - K) + 1);
            }
            if (!preSum.containsKey(currSum)) {
                preSum.put(currSum, i+1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lenOfLongSubarr(new int[]{10, 5, 2, 7, 1, 9}, 6, 15));
    }
}
