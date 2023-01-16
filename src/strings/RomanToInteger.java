package strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int getValue(Character character) {
        switch (character) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    public static int romanToInt(String s) {
        int res = 0;
        int prev = getValue(s.charAt(0));
        int len = s.length();
        for (int i = 1; i < len; i++) {
            int curr = getValue(s.charAt(i));
            if (prev < curr) {
                res -= prev;
            } else {
                res += prev;
            }
            prev = curr;
        }
        res += prev;
        return res;
    }

    /*public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'I' && i + 1 < chars.length) {
                if (chars[i + 1] == 'V') {
                    sum += 4;
                    i++;
                    continue;
                }
                if (chars[i + 1] == 'X') {
                    sum += 9;
                    i++;
                    continue;
                }
            }
            if (chars[i] == 'X' && i + 1 < chars.length) {
                if (chars[i + 1] == 'L') {
                    sum += 40;
                    i++;
                    continue;
                }
                if (chars[i + 1] == 'C') {
                    sum += 90;
                    i++;
                    continue;
                }
            }
            if (chars[i] == 'C' && i + 1 < chars.length) {
                if (chars[i + 1] == 'D') {
                    sum += 400;
                    i++;
                    continue;
                }
                if (chars[i + 1] == 'M') {
                    sum += 900;
                    i++;
                    continue;
                }
            }
            sum += map.get(chars[i]);
        }
        return sum;
    }*/

    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }
}
