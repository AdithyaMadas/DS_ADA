package arrays;

import java.util.Arrays;

//https://leetcode.com/problems/rearrange-array-elements-by-sign/
public class RearrangeBySign {

    public static int[] rearrangeArray(int[] nums) {
        int pos = 0, neg = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                swap(nums, i, neg);
                if (nums[i] > 0) {
                    pos += 2;
                    i++;
                }
                neg += 2;
            } else {
                swap(nums, i, pos);
                if (nums[i] < 0) {
                    neg += 2;
                    i++;
                }
                pos += 2;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

//    public static int[] rearrangeArray(int[] nums) {
//        int posIndex = 0, negIndex = 1;
//        int[] x = new int[nums.length];
//        for (int i : nums) {
//            if (i > 0) {
//                x[posIndex] = i;
//                posIndex += 2;
//            } else {
//                x[negIndex] = i;
//                negIndex += 2;
//            }
//        }
//        return x;
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));
    }
}
