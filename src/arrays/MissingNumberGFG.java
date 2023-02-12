package arrays;

public class MissingNumberGFG {
    public static int missingNumber(int A[], int N) {
        int ans = 0;
        for (int q : A) {
            ans ^= q;
        }
        for (int i = 1; i <= N; i++) {
            ans ^= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{1, 4, 3}, 4));
    }
}
