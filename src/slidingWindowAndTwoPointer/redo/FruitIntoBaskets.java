package slidingWindowAndTwoPointer.redo;

import java.util.HashMap;

public class FruitIntoBaskets {
    public static int totalFruits(int N, int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;
        for (int i = 0; i < N; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                Integer integer = map.get(fruits[left]);
                if (integer == 1) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], integer - 1);
                }
                left++;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(totalFruits(3, new int[]{1, 2, 1}));
        System.out.println(totalFruits(6, new int[]{0, 1, 2, 2, 2, 2}));
    }
}
