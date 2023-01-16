package stacksAndQueues;

import java.util.ArrayDeque;

public class RemoveKDigits {
    /*public static String removeKdigits(String num, int k) {
        while (k-- > 0) {
            num = removeNumber(num);
        }
        return num;
    }

    private static String removeNumber(String num) {
        if (num.length() == 0 || num.length() == 1) {
            return "0";
        }

        int i = 0;
        while (i < num.length() - 1 && num.charAt(i) <= num.charAt(i + 1)) {
            i++;
        }
        String res = num.substring(0, i) + num.substring(i + 1);
        i = 0;
        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }
        if (i == res.length()) {
            return "0";
        }
        return res;
    }*/

    public static String removeKdigits(String num, int k) {
        int i = 0;
        ArrayDeque<Character> stack = new ArrayDeque<>();

        if(k==num.length()) return "0";
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && c < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k-->0) stack.pop();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if(sb.length()==0) return "0";
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(removeKdigits("1234567890", 9));
    }
}
