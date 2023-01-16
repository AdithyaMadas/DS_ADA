package arrays;

import java.util.Arrays;

//https://leetcode.com/problems/rearrange-array-elements-by-sign/
public class RearrangeBySign {

    public static int[] rearrangeArray(int[] nums) {
        int posIndex = 0, negIndex = 1;
        int[] x = new int[nums.length];
        for (int i : nums) {
            if (i > 0) {
                x[posIndex] = i;
                posIndex += 2;
            } else {
                x[negIndex] = i;
                negIndex += 2;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
    }
}
