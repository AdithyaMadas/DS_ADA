package slidingWindowAndTwoPointer.redo;

public class BinaryArrayWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private static int atMost(int[] nums, int i) {
        if (i == -1) {
            return 0;
        }
        int currSum = 0, left = 0, res = 0;
        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];
            while (currSum > i) {
                currSum -= nums[left++];
            }
            res += right - left + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
    }
}
