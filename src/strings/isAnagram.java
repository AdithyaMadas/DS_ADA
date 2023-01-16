package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class isAnagram {
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                Integer count = map.get(c);
                if (count == 1) {
                    map.remove(c);
                } else {
                    map.put(c, count - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "cat"));
    }
}
