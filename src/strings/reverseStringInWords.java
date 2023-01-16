package strings;

public class reverseStringInWords {

    /*public static String reverseWord(String s) {
        int left = 0, right = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (left < right) {
            char tmp = charArray[left];
            charArray[left++] = charArray[right];
            charArray[right--] = tmp;
        }
        return String.valueOf(charArray);
    }*/
    public static String reverseWords(String s) {
        String[] strings = s.split(" ");
        int l = strings.length;
        StringBuilder toReturn = new StringBuilder();
        while (l-- > 0) {
            if (strings[l].length() > 0) {
                toReturn.append(strings[l] + " ");
            }
        }
        return toReturn.substring(0, toReturn.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
}
