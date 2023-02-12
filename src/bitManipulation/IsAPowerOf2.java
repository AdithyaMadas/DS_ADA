package bitManipulation;

public class IsAPowerOf2 {
    public static boolean isPowerofTwo(long n){
        if (n == 0) {
            return false;
        }
        return msb(n) == lsb(n);
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

    private static int lsb(long n) {
        int bit = 0;
        while (n != 0) {
            if ((n & (1)) != 0) {
                return bit;
            }
            bit++;
            n = n >> 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(isPowerofTwo(1));
        System.out.println(isPowerofTwo(2));
        System.out.println(isPowerofTwo(32));
        System.out.println(isPowerofTwo(90));
    }
}
