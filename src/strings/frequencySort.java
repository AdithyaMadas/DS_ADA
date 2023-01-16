package strings;

import java.util.*;

public class frequencySort {

    public static void buildString(StringBuilder sb, int character, int frequency) {
        while (frequency-- > 0) {
            sb.append((char) character);
        }
    }
    public static String frequencySort(String s) {
        int[][] charCount = new int[62][2];
        for (char c : s.toCharArray()) {
            if (c >= 65 && c <= 90) {
                charCount[c - 65][0] = c;
                charCount[c - 65][1]++;
            }
            if (c >= 97 && c <= 122) {
                charCount[c - 97 + 26][0] = c;
                charCount[c - 97 + 26][1]++;
            }
            if (c >= 48 && c <= 57) {
                charCount[c - 48 + 52][0] = c;
                charCount[c - 48 + 52][1]++;
            }
        }
        Arrays.sort(charCount, Collections.reverseOrder(Comparator.comparingInt(o -> o[1])));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 62; i++) {
            if (charCount[i][1] == 0) {
                break;
            }
            buildString(sb, charCount[i][0], charCount[i][1]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(frequencySort("2a554442f544asfasssffffasss"));
    }
}
