package slidingWindowAndTwoPointer.redo;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (set.contains(s.charAt(j))) {
                while (set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i++));
                }
            }
            set.add(s.charAt(j));
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
