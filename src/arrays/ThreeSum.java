package arrays;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        return threeSum(nums, 0);
    }

    private static List<List<Integer>> threeSum(int[] nums, int targetValue) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){    //If number is getting repeated, ignore the lower loop and continue.
                continue;
            }
            twoSum(nums, targetValue - nums[i], i + 1, res, nums[i]);
        }
        return res;
    }

    private static void twoSum(int[] nums, int target, int left, List<List<Integer>> res, int parentChose) {
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                int finalLeft = left;
                int finalRight = right;
                List<Integer> list = new ArrayList<Integer>() {{
                    add(parentChose);
                    add(nums[finalLeft]);
                    add(nums[finalRight]);
                }};
                res.add(list);
                int low = nums[left];
                while (left < right && nums[left] == low) {
                    left++;
                }
                int high = nums[right];
                while (left < right && nums[right] == high) {
                    high--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
