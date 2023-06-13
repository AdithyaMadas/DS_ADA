package slidingWindowAndTwoPointer.redo;

public class longestOnes {
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = -1, maxLen = 0;
        while (++right < nums.length) {
            if (nums[right] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[left++] == 0) {
                    k++;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}
