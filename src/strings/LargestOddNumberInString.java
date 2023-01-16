package strings;

public class LargestOddNumberInString {
    public static String largestOddNumber(String num) {
        int i = num.length() - 1;
        while (i >= 0) {
            if (Integer.parseInt(String.valueOf(num.charAt(i))) % 2 == 1) {
                return num.substring(0, i + 1);
            }
            i--;
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(largestOddNumber("4206"));
    }
}
