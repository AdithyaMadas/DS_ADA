package slidingWindowAndTwoPointer.redo;

import java.util.Arrays;

public class CharReplacement {
    public static int characterReplacement(String s, int k) {
        int left = 0, maxLen = 0;
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i)-'A']++;
            while (i - left + 1 > maxChar(charCount) + k) {
                charCount[s.charAt(left++)-'A']--;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    private static int maxChar(int[] charCount) {
        return Arrays.stream(charCount).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
