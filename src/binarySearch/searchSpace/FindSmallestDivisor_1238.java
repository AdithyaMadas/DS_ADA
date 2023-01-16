package binarySearch.searchSpace;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class FindSmallestDivisor_1238 {

    public static int getMaxofArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public static int getDivisorSum(int[] nums, int divisor) {
        int sum = 0;
        for (int i : nums) {
            sum += Math.ceil(i / (double) divisor);
        }
        return sum;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 0, high = getMaxofArray(nums), ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = getDivisorSum(nums, mid);
            if (sum > threshold) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{44,22,33,11,1}, 5));
    }
}
