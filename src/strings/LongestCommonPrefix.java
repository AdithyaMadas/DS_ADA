package strings;

public class LongestCommonPrefix {

    public static int minLenString(String[] strings) {
        int min = Integer.MAX_VALUE;
        for (String s : strings) {
            if (min > s.length()) {
                min = s.length();
            }
        }
        return min;
    }

    public static boolean prefixChar(String s, char c, int index) {
        return s.charAt(index) == c;
    }
    public static String longestCommonPrefix(String[] strs) {
        int i = 0;
        int min = minLenString(strs);
        StringBuilder s = new StringBuilder();
        while (i < min) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (!prefixChar(strs[j], c, i)) {
                    return s.toString();
                }
            }
            s.append(c);
            i++;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
