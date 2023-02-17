package recursion;
public class CombinationSum4 {

    static int ans;
    public static int combinationSum4(int[] nums, int target) {
        ans = 0;
        helper(nums, target, 0);
        return ans;
    }

    private static void helper(int[] nums, int target, int index) {
        if (target == 0) {
            ans++;
            return;
        }
        if (target < 0 || index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(nums[i]>target) break;
            helper(nums, target - nums[i], index);
        }
        helper(nums, target, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
