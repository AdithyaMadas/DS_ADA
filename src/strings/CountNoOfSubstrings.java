package strings;

public class CountNoOfSubstrings {
    static long substrCount (String S, int K) {
        return atMostK(S, K) - atMostK(S, K - 1);
    }

    private static long atMostK(String s, int i) {
        long ans = 0;
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(substrCount("aba", 2));
        System.out.println(substrCount("abaaca", 1));
    }
}
