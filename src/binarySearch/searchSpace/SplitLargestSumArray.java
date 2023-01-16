package binarySearch.searchSpace;

//https://leetcode.com/problems/split-array-largest-sum/description/
public class SplitLargestSumArray {


    //don;t know why it isn;t working

    public static int[] minAndSumOfArray(int[] nums) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int i : nums) {
            sum += i;
            if (i < min) {
                min = i;
            }
        }
        return new int[]{min, sum};
    }

    public static int numberOfChunks(int[] nums, int capacity) {
        int chunks = 1, sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            if (sum > capacity) {
                chunks++;
                sum = nums[i];
            }
        }
        return chunks;
    }

    public static int splitArray(int[] nums, int k) {
        int[] lowSum = minAndSumOfArray(nums);
        int low = lowSum[0], high = lowSum[1];
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numberOfChunks(nums, mid) <= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{1,4,4}, 3));
    }
}
