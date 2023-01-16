package slidingWindowAndTwoPointer;

public class NumberOfSubstringsWithABC {
    public static int numberOfSubstrings(String s) {
        int min_a = -1, min_b = -1, min_c = -1, res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                min_a = i;
            }else if (s.charAt(i) == 'b') {
                min_b = i;
            }if (s.charAt(i) == 'c') {
                min_c = i;
            }
            res += Math.min(Math.min(min_a, min_b), min_c) + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abc"));
    }
}
