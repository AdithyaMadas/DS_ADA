package bitManipulation;

public class DivideNumber {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        int res = 0;
        while (a-b >= 0) {
            int x = 0;
            while ((a - (b << 1 << x)) >= 0) {
                x++;
            }
            res += (1 << x);
            a = a - (b << x);
        }
        return dividend >= 0 == divisor >= 0 ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(divide(10, -3));
        System.out.println(divide(-2147483648, 2));
    }
}
