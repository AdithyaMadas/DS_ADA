package greedy;

public class JumpGame2 {
    public static int jump(int[] nums) {
        int jumps = 0, maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxReach >= nums.length - 1) {
                break;
            }
            for (int j = maxReach; j >= i; j--) {
                maxReach = Math.max(nums[j] + j, maxReach);
            }
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
    }
}
