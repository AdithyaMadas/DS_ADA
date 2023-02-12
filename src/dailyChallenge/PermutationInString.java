package dailyChallenge;

import java.util.HashMap;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] countMap = new int[26];
        for (char c : s1.toCharArray()) {
            countMap[c - 'a']++;
        }
        int left = 0, right = s1.length();
        for (int i = 0; i < right; i++) {
            countMap[s2.charAt(i) - 'a']--;
        }
        if (allZero(countMap)) return true;
        while (right < s2.length()) {
            countMap[s2.charAt(left++) - 'a']++;
            countMap[s2.charAt(right++) - 'a']--;
            if (allZero(countMap)) return true;
        }
        return false;
    }

    private static boolean allZero(int[] countMap) {
        for (int i = 0; i < 26; i++) {
            if(countMap[i]!=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("adc", "dcda"));
    }
}
