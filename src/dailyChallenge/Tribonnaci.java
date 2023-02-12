package dailyChallenge;

public class Tribonnaci {
    public static int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1||n==2) return 1;
        return tribonacci(0, 1, 1, n - 2);
    }

    private static int tribonacci(int i, int i1, int i2, int n) {
        if (n == 0) {
            return i2;
        }
        return tribonacci(i1, i2, i + i1 + i2, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
}
