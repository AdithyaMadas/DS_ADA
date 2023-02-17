package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return find(s, set);
    }

    private static boolean find(String s, HashSet<String> set) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.substring(0, i + 1))) {
                if (find(s.substring(i + 1), set)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", new ArrayList<String>() {{
            add("leet");
            add("code");
        }}));
        System.out.println(wordBreak("applepenapple", new ArrayList<String>() {{
            add("apple");
            add("pen");
        }}));
        System.out.println(wordBreak("catsandog", new ArrayList<String>() {{
            add("cats");
            add("dog");
            add("sand");
            add("and");
            add("cat");
        }}));
    }
}
