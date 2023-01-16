package arrays;

import java.util.Arrays;

//Same as MaxSubArray but you need to print the array
public class PrintMaxSubArray {

    public static int[] printMaxSubArray(int[] nums) {
        int currSum = 0, maxSum = nums[0];
        int start = 0, toStart = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (currSum > maxSum) {
                maxSum = currSum;
                toStart = start;
                end = i;
            }
            if (currSum < 0) {
                currSum = 0;
                start = i + 1;
            }
        }
        int[] toReturn = new int[end - toStart + 1];
        int j = 0;
        for (int i = toStart; i <= end; i++) {
            toReturn[j++] = nums[i];
        }
        return toReturn;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(printMaxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})));
    }

}
