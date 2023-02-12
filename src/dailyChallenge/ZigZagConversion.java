package dailyChallenge;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < numRows) {
            appendStringForRow(i++, numRows, sb, s);
        }
        return sb.toString();
    }

    private static void appendStringForRow(int row, int numRows, StringBuilder sb, String s) {
        if (row == 0 || row == numRows - 1) {
            int distance = 2 * (numRows - 1);
            for (int i = row; i < s.length(); i += distance) {
                sb.append(s.charAt(i));
            }
        } else {
            int distance1 = 2 * (numRows - row - 1), distance2 = 2 * (row);
            int i = row, counter = 0;
            while (i < s.length()) {
                sb.append(s.charAt(i));
                if (counter % 2 == 0) {
                    i += distance1;
                    counter++;
                } else {
                    i += distance2;
                    counter++;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
        System.out.println(convert("A", 1));
    }
}
