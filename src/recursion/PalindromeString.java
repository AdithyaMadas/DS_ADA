package recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PalindromeString {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        generate(s, 0, res, new LinkedList<>());
        return res;
    }

    private static void generate(String s, int start, List<List<String>> res, LinkedList<String> currList) {
        if (start == s.length()) {
            res.add(new ArrayList<>(currList));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                currList.addLast(s.substring(start, i + 1));
                generate(s, i + 1, res, currList);
                currList.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
}
