package dailyChallenge;

import java.util.Arrays;

public class MaxSumCircularSubArray {
    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];
        int currSum = nums[n - 1];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            currSum += nums[i];
            rightMax[i] = Math.max(rightMax[i + 1], currSum);
        }
        currSum = nums[0];
        int maxSum = nums[0], specialSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);


            maxSum = Math.max(maxSum, specialSum + rightMax[i]);
            specialSum += nums[i];
        }
        return maxSum;
    }

//    public static int maxSubarraySumCircular(int[] nums) {
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            max = Math.max(max, getMax(nums));
//            rotate(nums);
//        }
//        return max;
//    }
//
//    public static void rotate(int[] nums) {
//        int n = nums[nums.length - 1];
//        for (int i = nums.length - 2; i >= 0; i--) {
//            nums[i + 1] = nums[i];
//        }
//        nums[0] = n;
//    }
//
//
//    public static int getMax(int[] nums) {
//        int sum = 0, maxSum = Integer.MIN_VALUE;
//        for (int i : nums) {
//            sum += i;
//            maxSum = Math.max(maxSum, sum);
//            if (sum < 0) {
//                sum = 0;
//            }
//        }
//        return maxSum;
//    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{-3, -2, -3}));
    }
}
