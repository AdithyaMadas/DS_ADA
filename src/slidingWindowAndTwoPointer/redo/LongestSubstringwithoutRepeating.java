package slidingWindowAndTwoPointer.redo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringwithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0, left = 0;
        HashSet<Character> map = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.contains(s.charAt(i))) {
                while (map.contains(s.charAt(i))) {
                    map.remove(s.charAt(left++));
                }
            }
            maxLen = Math.max(maxLen, i - left + 1);
            map.add(s.charAt(i));
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("abba"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
