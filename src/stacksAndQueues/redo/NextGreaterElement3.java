package stacksAndQueues.redo;

import java.util.Stack;

public class NextGreaterElement3 {
    public static int nextGreaterElement(int n) {
        String num = String.valueOf(n);
        int i = num.length() - 2;
        while (true) {
            if (i == -1) {
                return -1;
            }
            if (num.charAt(i) >= num.charAt(i + 1)) {
                i--;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(num, 0, i);
                int index = findElementGreater(num, i);
                stringBuilder.append(num.charAt(index));
                reverse(stringBuilder, num.substring(i + 1, index) + num.charAt(i) + num.substring(index + 1));
                if (Long.parseLong(stringBuilder.toString()) > Integer.MAX_VALUE) {
                    return -1;
                } else {
                    return Integer.parseInt(stringBuilder.toString());
                }
            }
        }
    }

    private static int findElementGreater(String num, int i) {
        char c = num.charAt(i);
        int index = num.length() - 1;
        while (index > i) {
            if (num.charAt(index) > c) {
                return index;
            }
            index--;
        }
        return -1;
    }

    private static void reverse(StringBuilder stringBuilder, String num) {
        int i = num.length() - 1;
        while (i >= 0) {
            stringBuilder.append(num.charAt(i));
            i--;
        }
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement(241));
        System.out.println(nextGreaterElement(3142));
        System.out.println(nextGreaterElement(123));
        System.out.println(nextGreaterElement(21));
    }
}
