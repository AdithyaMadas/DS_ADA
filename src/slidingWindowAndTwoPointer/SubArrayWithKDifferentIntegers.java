package slidingWindowAndTwoPointer;

import java.util.HashMap;

public class SubArrayWithKDifferentIntegers {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDifferent(nums, k) - atMostKDifferent(nums, k - 1);
    }

    private static int atMostKDifferent(int[] nums, int k) {
        if(k<0) return 0;
        int i = 0, j = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() > k) {
                Integer newCount = map.get(nums[i]) - 1;
                if (newCount == 0) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], newCount);
                }
                i++;
            }
            j++;
            res += j - i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[]{1,2}, 1));
    }
}
