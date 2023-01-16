package slidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class longestKUniqueCharacters {
    public static int longestkSubstr(String s, int k) {
        int res = -1;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, maxLen = -1;
        for (int j = 0; j < s.length(); j++) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if (map.size() == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            while (map.size() > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                i++;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestkSubstr("aaaa", 2));
    }
}
