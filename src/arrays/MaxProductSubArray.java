package arrays;

import java.util.Arrays;
import java.util.Map;

public class MaxProductSubArray {
    public static int maxProduct(int[] nums) {
        int res = Arrays.stream(nums).max().getAsInt();
        int max = 1, min = 1;
        for (int i : nums) {
            if (i == 0) {
                max = 1;
                min = 1;
            }
            int tmp = i * max;
            max = Math.max(tmp, Math.max(i * min, i));
            min = Math.min(tmp, Math.min(i * min, i));
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{-2, -3, 4}));
        System.out.println(maxProduct(new int[]{3, -1, 4}));
        System.out.println(maxProduct(new int[]{2, -5, -2, -4, 3}));
    }
}
