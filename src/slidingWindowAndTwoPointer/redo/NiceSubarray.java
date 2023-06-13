package slidingWindowAndTwoPointer.redo;

public class NiceSubarray {
    public static int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        if (k == -1) {
            return 0;
        }
        int left = 0, res = 0, currOdd = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                currOdd++;
            }
            while (currOdd > k) {
                if ((nums[left++] & 1) == 1) {
                    currOdd--;
                }
            }
            res += i - left + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
        System.out.println(numberOfSubarrays(new int[]{2, 4, 6}, 1));
        System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }
}
