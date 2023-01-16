package bitManipulation;

public class NumberIsPowerOf2 {
    public static boolean isPowerOfTwo(int n) {
        if (n == 0 || n == Integer.MIN_VALUE || n == Integer.MAX_VALUE) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(0));
        System.out.println(~15);
    }
}
