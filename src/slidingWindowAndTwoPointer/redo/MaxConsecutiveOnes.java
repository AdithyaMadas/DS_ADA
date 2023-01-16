package slidingWindowAndTwoPointer.redo;

public class MaxConsecutiveOnes {
    public static int longestOnes(int[] nums, int k) {
        int i = 0, maxLen = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[i++] == 0) {
                    k++;
                }
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
