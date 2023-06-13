package slidingWindowAndTwoPointer.redo;

import java.util.HashMap;

public class SubarrayWithKDistinct {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return getAtMost(nums, k) - getAtMost(nums, k - 1);
    }

    private static int getAtMost(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() > k) {
                Integer integer = map.get(nums[left]);
                if (integer == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], integer - 1);
                }
                left++;
            }
            res += i - left + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 3, 4}, 3));
    }
}
