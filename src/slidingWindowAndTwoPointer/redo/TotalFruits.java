package slidingWindowAndTwoPointer.redo;

import java.util.HashMap;

public class TotalFruits {
    public static int totalFruits(int N, int[] fruits) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int i = 0, maxLen = 0;
        for (int j = 0; j < N; j++) {
            count.put(fruits[j], count.getOrDefault(fruits[j], 0) + 1);
            if (count.size() > 2) {
                Integer newCount = count.get(fruits[i]) - 1;
                if (newCount == 0) {
                    count.remove(fruits[i]);
                } else {
                    count.put(fruits[i], newCount);
                }
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(totalFruits(3, new int[]{0, 1, 2, 2, 2, 2}));

    }
}
