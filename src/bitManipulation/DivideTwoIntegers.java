package bitManipulation;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MAX_VALUE) {
            if (divisor == 1) {
                return dividend;
            } else if (divisor == -1) {
                return Integer.MIN_VALUE;
            }
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return dividend;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        long up = Math.abs((long)dividend);
        long down = Math.abs((long)divisor);
        long quotient = 0;

        /*for (int i = 31; i >= 0; i--) {
            if (tmp + down << i <= up) {
                tmp += down << i;
                quotient |= 1L << i;
            }
        }*/

        while (up - down >= 0) {
            int x = 0;
            while (up - (down << 1 << x) >= 0) {
                x++;
            }
            quotient |= 1 << x;
            up -= down << x;
        }

        return (int) (((dividend > 0) ^ (divisor > 0)) ? -quotient : quotient);
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 2));
    }
}
