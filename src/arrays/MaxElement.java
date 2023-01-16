package arrays;

public class MaxElement {

    public static int getMax(int[] x) {
        int max = Integer.MIN_VALUE;
        for (int i : x) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(getMax(new int[]{3, 12, 56, 85, 20}));
    }
}
