package slidingWindowAndTwoPointer.redo;

public class NumberOfSubstringsContainingABC {
    public static int numberOfSubstrings(String s) {
        int res = 0, left = 0;
        int[] a = new int[3];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
            while (a[0] > 0 && a[1] > 0 && a[2] > 0) {
                a[s.charAt(left++) - 'a']--;
                res += s.length() - i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));
        System.out.println(numberOfSubstrings("aaacb"));
        System.out.println(numberOfSubstrings("abc"));
    }
}
