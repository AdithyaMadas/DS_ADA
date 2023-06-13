package dailyChallenge;

public class findIndexOccurenceInString {
    public static int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        int length = haystack.length();
        int length1 = needle.length();
        while (i < length) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == length1) {
                return i - length1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("mississippi", "issip"));
        System.out.println(strStr("leetcode", "leeto"));
    }
}
