package dailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (isPalindrome(s, j, j + i)) {
                    List<String> list = new ArrayList<>();
                    res.add(list);
                }
            }
        }
        return res;
    }

    private static boolean isPalindrome(String s, int i, int i1) {
        while (i < i1) {
            if (s.charAt(i++)!=s.charAt(i1--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aaab"));
    }
}
