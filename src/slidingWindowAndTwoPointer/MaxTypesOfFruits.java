package slidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class MaxTypesOfFruits {
    public static int totalFruits(int N, int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>(); int l = 0, r = 0, maxLen = 0;
        while (r < N) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while (map.size() > 2) {
                if (map.get(fruits[l]) == 1) {
                    map.remove(fruits[l]);
                    l++;
                } else {
                    map.put(fruits[l], map.get(fruits[l]) - 1);
                    l++;
                }
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(totalFruits(22, new int[]{17,7,0,5,11,5,4,5,12,14,21,17,11,11,17,7,8,18,21,14,16,2 }));


    }
}
