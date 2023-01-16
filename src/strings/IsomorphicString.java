package strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicString {

    public static String transformString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                sb.append(map.get(c)).append(" ");
            } else {
                map.put(c, counter++);
                sb.append(map.get(c)).append(" ");
            }
        }
        return sb.toString();
    }
    public static boolean isIsomorphic(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        if (sArray.length != tArray.length) {
            return false;
        }
        return transformString(s).equalsIgnoreCase(transformString(t));
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }
}
