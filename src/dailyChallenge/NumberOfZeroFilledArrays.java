package dailyChallenge;

public class NumberOfZeroFilledArrays {
    public static long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int index = i + 1;
                while (index < nums.length && nums[index] == 0) {
                    index++;
                }
                long n = index - i;
                ans += (n * (n + 1)) >> 1;
                i = index;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));
        System.out.println(zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0}));
    }
}
