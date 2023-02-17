package recursion;

import java.util.HashSet;
import java.util.Set;

public class BetterString {
    public static String betterString(String str1, String str2) {
        Set<String> set = new HashSet<>();
        findDistinct(set, str1,"", 0);
        Set<String> set2 = new HashSet<>();
        findDistinct(set2, str2, "", 0);
        return set.size() >= set2.size() ? str1 : str2;
    }

    private static void findDistinct(Set<String> set, String str1, String currString, int index) {
        set.add(currString);
        if (index == str1.length()) {
            return;
        }
        findDistinct(set, str1, currString, index + 1);
        findDistinct(set, str1, currString + str1.charAt(index), index + 1);
    }

    public static void main(String[] args) {
        System.out.println(betterString("gfg", "ggg"));
        System.out.println(betterString("a", "b"));
    }
}
