package slidingWindowAndTwoPointer;

import java.util.*;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int l = 0, maxLen = 0;
        int[] count = new int[26];
        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r) - 'A']++;
            int window_len = r - l + 1;
            while (window_len - mostRepeatingChar(count) > k) {
                count[s.charAt(l) - 'A']--;
                l++;
                window_len = r - l + 1;
            }
            maxLen = Math.max(maxLen, window_len);
        }
        return maxLen;
    }

    private static int mostRepeatingChar(int[] count) {
        int max = 0;
        for (int i : count) {
            max = Math.max(max, i);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
