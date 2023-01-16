package bitManipulation;

public class MinBitFlips {
    public static int minBitFlips(int start, int goal) {
        return countBits(start ^ goal);
    }

    private static int countBits(int i) {
        int count = 0;
        while (i > 0) {
            i &= i - 1;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minBitFlips(3, 4));
    }
}
