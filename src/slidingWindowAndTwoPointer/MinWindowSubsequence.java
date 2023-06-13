package slidingWindowAndTwoPointer;

//https://www.youtube.com/watch?v=W2DvQcDPD9A
public class MinWindowSubsequence {
    static String minWindow(String str1, String str2) {
        String res = str1 + "a";
        int i = 0;
        for (int j = 0; j < str1.length(); j++) {
            if (str1.charAt(j) == str2.charAt(i)) {
                i++;
            }
            if (i == str2.length()) {
                int minStart = j;
                i--;
                while (i >= 0) {
                    if (str1.charAt(minStart) == str2.charAt(i)) {
                        i--;
                    }
                    minStart--;
                }
                i++;
                minStart++;
                if (minStart - j +1 < res.length()) {
                    res = str1.substring(minStart, j + 1);
                }
            }
        }
        return res.length() > str1.length() ? "" : res;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("geeksforgeeks", "eksrg"));
        System.out.println(minWindow("ierfwenhfa", "efna"));

    }
}
