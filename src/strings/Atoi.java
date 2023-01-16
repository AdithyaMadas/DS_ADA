package strings;

public class Atoi {
    public static int myAtoi(String s) {
        int i = 0;
        boolean isNegative = false;
        double result = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                isNegative = s.charAt(i) == '-';
                i++;
                break;
            }
            if (s.charAt(i) == ' ') {
                i++;
            } else {
                break;
            }
        }
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                result = result * 10 + (s.charAt(i) - '0');
            } else {
                break;
            }
            i++;
        }
        if(isNegative) result *= -1;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("00000-42a1234"));
    }
}
