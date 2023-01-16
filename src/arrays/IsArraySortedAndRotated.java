package arrays;

// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
public class IsArraySortedAndRotated {

    public static boolean isSorted(int[] x) {
        boolean rotated = false;
        int rotatedAt = -1;
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) {
                rotatedAt = i;
                rotated = true;
                break;
            }
        }
        if(!rotated) return true;
        for (int i = rotatedAt + 1; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) {
                return false;
            }
        }

        if (rotated) {
            return x[0] >= x[x.length - 1];
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{6,10,6}));
        System.out.println(isSorted(new int[]{3, 4, 1, 2,}));
    }
}
