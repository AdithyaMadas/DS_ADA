package dailyChallenge;

public class GreatestCommonDivisorOfStrings {
    public static String gcdOfStrings(String str1, String str2) {
        if (!(str2 + str1).equalsIgnoreCase(str1 + str2)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private static int gcd(int len1, int len2) {
        if(len2 == 0) return len1;
        return gcd(len2, len1 % len2);
    }

    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
    }
}
