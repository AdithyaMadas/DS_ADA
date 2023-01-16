package arrays;

//https://leetcode.com/problems/maximum-subarray/
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int currSum = 0, maxSum = nums[0];
        for (int i : nums) {
            currSum += i;
            if (maxSum < currSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
