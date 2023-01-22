package dailyChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestoreIPAddress {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) {
            return res;
        }
        getAllValidIP(s, 0, 0, res, "");
        return res;
    }

    private static void getAllValidIP(String s, int dotsCount, int index, List<String> res, String currString) {
        if (dotsCount == 4 && index == s.length()) {
            res.add(currString.substring(0, currString.length() - 1));
            return;
        }

        if (dotsCount > 4) {
            return;
        }
        int end = Math.min(s.length(), index + 3);
        for (int j = index; j < end; j++) {
            String substring = s.substring(index, j + 1);
            if (Integer.parseInt(substring) < 256 && (index == j || s.charAt(index) != '0')) {
                getAllValidIP(s, dotsCount + 1, j + 1, res, currString + substring + ".");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
