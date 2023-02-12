package arrays;

import java.util.HashMap;

public class MaxLen {
    static int maxLen(int arr[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum = 0, maxLen = -1;
        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            if (arr[i] == 0 && maxLen == 0)
                maxLen = 1;

            if (currSum == 0)
                maxLen = i + 1;

            if (map.containsKey(currSum)) {
                if (maxLen < i - map.get(currSum)) {
                    maxLen = i - map.get(currSum);
                }
            } else {
                map.put(currSum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(maxLen(new int[]{-1, 1, -1, 1}, 4));
    }
}
