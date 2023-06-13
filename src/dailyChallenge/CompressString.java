package dailyChallenge;

import java.util.Stack;

public class CompressString {
    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        int i = 0, j = 0;
        while (i < chars.length) {
            int groupLen = 1;
            while (i + groupLen < chars.length && chars[i + groupLen] == chars[i]) {
                groupLen++;
            }
            chars[j++] = chars[i];
            if (groupLen > 1) {
                for (char c : Integer.toString(groupLen).toCharArray()) {
                    chars[j++] = c;
                }
            }
            i += groupLen;
        }
        return j;
    }

    public static void main(String[] args) {
//        char[] chars = "aabbccc".toCharArray();
        char[] chars = "aaaaab".toCharArray();
        System.out.println(compress(chars));
        System.out.println(chars);
    }
}
