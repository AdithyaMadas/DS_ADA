package bitManipulation;

public class PowerOfANumber {
    //https://leetcode.com/problems/powx-n/solutions/739646/c-iterative-vs-recursive-bitwise-solutions-explained-100-time-80-space/?orderBy=most_votes
    public static double myPow(double x, int n) {
        double res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res = n > 0 ? res * x : res / x;
            }
            x *= x;
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10));
        System.out.println(myPow(2.1, 3));
        System.out.println(myPow(2.0, -2));
    }
}
