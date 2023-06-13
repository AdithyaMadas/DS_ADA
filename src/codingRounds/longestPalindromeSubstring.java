package codingRounds;

public class longestPalindromeSubstring {
    public static void funcSubstring(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = findPalindromeWithCenter(s, i, i);
            int len2 = findPalindromeWithCenter(s, i, i+1);
            int len = Math.max(len2, len1);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + (len) / 2;
            } else if (len == end - start + 1) {
                if (isGreater(s, start, end, i - (len - 1) / 2, i + (len) / 2)) {
                    start = i - (len - 1) / 2;
                    end = i + (len) / 2;
                }
            }
        }
        if (end != start) {
            System.out.println(s.substring(start, end + 1));
        } else {
            System.out.println("None");
        }
    }

    private static boolean isGreater(String s, int start, int end, int i, int i1) {
        int w = 0;
        for (int q = start; q <= end; q++, w++) {
            if (s.charAt(q) > s.charAt(i + w)) {
                return true;
            }
        }
        return false;
    }

    public static int findPalindromeWithCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    public static void main(String[] args) {
        funcSubstring("ZUUZABA");
    }
}
