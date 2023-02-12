package bitManipulation;

public class CountSetBits {
    public static int countSetBits(int n) {
        if(n==1||n==0) return n;
        int m = msb(n);
        if (n == (1 << (m + 1)) - 1) {
            return (m+1) * (1 << (m));
        }
        return (n - ((1 << m) - 1)) + countSetBits(n - (1 << (m))) + countSetBits((1 << (m)) - 1);
    }

    private static int msb(long n) {
        int bit = 0;
        while (n != 0) {
            if ((n | (1)) == 1) {
                return bit;
            }
            bit++;
            n = n >> 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(4));
        System.out.println(countSetBits(5));
        System.out.println(countSetBits(6));
        System.out.println(countSetBits(7));
        System.out.println(countSetBits(17));
    }
}
