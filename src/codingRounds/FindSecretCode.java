package codingRounds;

import java.math.BigInteger;

public class FindSecretCode {
    public static int  findSecretCode(int secretCode, int firstKey, int secondKey)
    {
        BigInteger M, ans;
        ans = BigInteger.valueOf(lastDigit(secretCode, firstKey));
        BigInteger b2 = new BigInteger("1000000007");
        M = BigInteger.valueOf(secondKey);
        ans = ans.pow(M.intValue());
        ans = ans.mod(b2);
        return ans.intValue();

    }

    public static int lastDigit(long a, long b) {
        if (b == 0) {
            return 1;
        }
        if (a == 0) {
            return 0;
        }
        int[][] digits = {{0,0,0,0},{1,1,1,1},{6,2,4,8},{1,3,9,7},{6,4,6,4},{5,5,5,5},{6,6,6,6},{1,7,9,3},{6,8,4,2},{1,9,1,9}};
        int lastDigitA = (int)(a % 10);
        int lastDigitB = (int)(b % 4);
        return digits[lastDigitA][lastDigitB];
    }


    public static void main(String[] args) {
        System.out.println(findSecretCode(2, 3, 4));
    }
}
