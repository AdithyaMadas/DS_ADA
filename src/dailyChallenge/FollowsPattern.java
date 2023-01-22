package dailyChallenge;

import java.util.HashSet;
import java.util.Set;

public class FollowsPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] word = new String[26];
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (word[pattern.charAt(i) - 'a'] == null) {
                if (set.contains(words[i])) {
                    return false;
                }
                word[pattern.charAt(i) - 'a'] = words[i];
                set.add(words[i]);
            } else {
                if (!word[pattern.charAt(i) - 'a'].equalsIgnoreCase(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
