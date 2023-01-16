package recursion;

import java.math.BigInteger;

import static java.lang.String.valueOf;

public class CountGoodNumbers {

    public static int M = 1000000000 + 7;
    public static int countGoodNumbers(long n) {

        int ans = 1;
        if (n % 2 == 1) {
            ans = 5;
        }
        return (int) (power(20, n/2) * ans % M) % M;
    }

    public static long power(long x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return power(((x % M) * (x % M)) % M, n/2) % M;
        } else {
            return ((x % M) * power(((x % M) * (x % M)) % M, (n - 1)/2)) % M;
        }
    }


    //iteration
    /*public static int countGoodNumbers(long n) {
        boolean flag = false;
        if (n % 2 == 1) {
            flag = true;
            n--;
        }
        BigInteger mod = new BigInteger(valueOf(1000000007));
        BigInteger x = new BigInteger(valueOf(n));
        BigInteger result = new BigInteger(valueOf(20)).modPow(new BigInteger(valueOf(n / 2)), mod);
        if (flag) {
            result = result.multiply(new BigInteger(String.valueOf(5)));
            result = result.mod(mod);
        }
        return result.intValue();
    }*/

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1));
    }
}
