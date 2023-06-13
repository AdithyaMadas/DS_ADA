package codingRounds;

import java.util.Arrays;
import java.util.regex.Pattern;

public class IsValidCoordinates {
    public static String[]  funcValidPairs(String[] inputStr)
    {
        String[] answer = new String[inputStr.length];
        Pattern p = Pattern.compile("^\\([-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?|(\\.\\d+)?),[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?|(\\.\\d+)?)\\)$");
        for (int i = 0; i < inputStr.length; i++) {
            if (p.matcher(inputStr[i]).matches()) {
                answer[i] = "Valid";
            } else {
                answer[i] = "Invalid";
            }
        }

        return answer;
    }

    private static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] != '(') {
            return false;
        }
        if (chars[chars.length - 1] != ')') {
            return false;
        }
        int i = 1;
        int comma = findComma(chars, 1, chars.length - 2);
        if (comma == -1) {
            return false;
        }
        if (!isValidNumber(s.substring(1,comma), true)) {
            return false;
        }
        if (!isValidNumber(s.substring(comma + 1, chars.length - 2), false)) {
            return false;
        }
        return true;
    }

    private static boolean isValidNumber(String substring, boolean x) {
        if (substring.charAt(substring.length() - 1) == '.') {
            return false;
        }
        try {
            Float aFloat = Float.valueOf(substring);
            if (x && aFloat <= 90 && aFloat >= -90) {
                return true;
            }
            if (!x && aFloat <= 180 && aFloat >= -180) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private static int findComma(char[] chars, int start, int end) {
        int index = -1, space = -1;
        for (int i = start; i <= end; i++) {
            if (chars[i] == ',') {
                index = i;
            }
            if (chars[i] == ' ') {
                space = i;
            }
        }
        return space == -1 ? index : -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(funcValidPairs(new String[]{"(+90,.180)"})));
    }
}
