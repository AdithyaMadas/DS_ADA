package dailyChallenge;

import java.util.ArrayList;
import java.util.List;

public class IsAnagram {
    public static List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length()) return new ArrayList<>();
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        int left = 0, right = 0;
        while (right < p.length()) {
            count[s.charAt(right++) - 'a']--;
        }
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            if (allZero(count)) {
                res.add(left);
            }
            count[s.charAt(left++) - 'a']++;
            count[s.charAt(right++) - 'a']--;
        }
        if (allZero(count)) {
            res.add(left);
        }
        return res;
    }

    private static boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if(count[i]!=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
    }
}
