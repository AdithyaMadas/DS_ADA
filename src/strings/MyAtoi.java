package strings;

public class MyAtoi {
    public static int myAtoi(String s) {
        int state = 0, sign = 1, res = 0;
        for (char c : s.toCharArray()) {
            if (state == 0) {
                if (c != ' ') {
                    state = 1;
                }
            }
            if (state == 1) {
                if (c == '+' || c == '-') {
                    state = 2;
                    sign = c == '+' ? 1 : -1;
                    continue;
                } else {
                    state = 2;
                }
            }
            if (state == 2) {
                if (c >= '0' && c <= '9') {
                    if ((long) res * 10 + (c - '0') > Integer.MAX_VALUE) {
                        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    } else {
                        res = res * 10 + (c - '0');
                    }
                } else {
                    break;
                }
            }
        }
        return sign * res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
    }
}
