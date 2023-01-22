package dailyChallenge;

public class MinFlipsToMakeMonotonicIncreasing {
    public static int minFlipsMonoIncr(String s) {
        int m = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                m++;
            }
        }
        if (m == 0 || m == s.length()) {
            return 0;
        }
        int ans = m;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                m--;
                ans = Math.min(ans, m);
            } else {
                m++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00110"));
        System.out.println(minFlipsMonoIncr("010110"));
        System.out.println(minFlipsMonoIncr("00011000"));
    }
}
