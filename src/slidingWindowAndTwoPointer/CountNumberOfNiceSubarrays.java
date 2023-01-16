package slidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays {
    /*public static int numberOfSubarrays(int[] nums, int goal) {

        int res = 0, sum = 0;
        int[] count = new int[nums.length];
        count[0]++;
        for (int i : nums) {
            sum += i % 2;
            if (sum - goal >= 0) {
                res += count[sum - goal];
            }
            count[sum]++;
        }
        return res;
    }*/

    public static int numberOfSubarrays(int[] A, int k) {
        int res = 0, i = 0, count = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            if (A[j] % 2 == 1) {
                --k;
                count = 0;
            }
            while (k == 0) {
                k += A[i++] & 1;
                ++count;
            }
            res += count;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }
}
