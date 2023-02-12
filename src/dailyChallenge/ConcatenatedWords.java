package dailyChallenge;

import java.util.*;

public class ConcatenatedWords {

    static Set<String> set;
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        set = new HashSet<>(Arrays.asList(words));
        List<String> res = new ArrayList<>();
        for (String s : words) {
            if (checkMultipleWords(s)) {
                res.add(s);
            }
        }
        return res;
    }

    private static boolean checkMultipleWords(String s) {
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if (set.contains(prefix) && set.contains(suffix) || checkMultipleWords(suffix)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict(words));
    }
}
