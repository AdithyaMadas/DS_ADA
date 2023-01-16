package dailyChallenge;

import java.util.*;

//https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
public class LexicallySmallestString {
    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] smallest = new int[26];
        for (int i = 0; i < 26; i++) {
            smallest[i] = i;
        }
        for (int i = 0; i < s1.length(); i++) {
            int c1 = smallest[s1.charAt(i) - 'a'];
            int c2 = smallest[s2.charAt(i) - 'a'];
            int toReplace = Math.max(c1, c2);
            int replaceWith = Math.min(c1, c2);

            for (int j = 0; j < 26; j++) {
                if (smallest[j] == toReplace) {
                    smallest[j] = replaceWith;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append((char) (smallest[c - 'a'] + 'a'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(smallestEquivalentString("leetcode", "programs", "sourcecode"));
//        System.out.println(smallestEquivalentString("abc", "cde", "eed"));
    }
}
