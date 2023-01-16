package slidingWindowAndTwoPointer.redo;

import java.util.Arrays;

public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            charCount[s.charAt(j) - 'A']++;
            if (j - i + 1 - mostRepeating(charCount) > k) {
                charCount[s.charAt(i++) - 'A']--;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    private static int mostRepeating(int[] charCount) {
        return Arrays.stream(charCount).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABABBA", 1));
    }
}
