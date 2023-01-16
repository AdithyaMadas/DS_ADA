package slidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0, j = 0, startMinIndex = 0, endMinIndex = 100000, count = map.size();
        char[] chars = s.toCharArray();
        while (j < chars.length) {
            if (map.containsKey(chars[j])) {
                int newCharCount = map.get(chars[j]) - 1;
                map.put(chars[j], newCharCount);
                if (newCharCount == 0) {
                    count--;
                }
            }


            if (count == 0) {
                while (count == 0) {
                    if (map.containsKey(s.charAt(i))) {
                        Integer newCount = map.get(s.charAt(i)) + 1;
                        map.put(s.charAt(i), newCount);
                        if (newCount > 0) {
                            count++;
                        }
                    }
                    i++;
                }
                if (endMinIndex - startMinIndex > j - i) {
                    endMinIndex = j;
                    startMinIndex = i - 1;
                }
            }
            j++;
        }
        return endMinIndex - startMinIndex + 1 > s.length() ? "" : s.substring(startMinIndex, endMinIndex + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }
}
