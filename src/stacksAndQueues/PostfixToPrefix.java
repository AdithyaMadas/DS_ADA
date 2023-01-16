package stacksAndQueues;

import java.util.Stack;

public class PostfixToPrefix {
    static String postToPre(String post_exp) {
        Stack<String> stack = new Stack<>();
        for (char c : post_exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String b = stack.pop();
                String a = stack.pop();
                stack.push(c + a + b);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(postToPre("ABC/-AK/L-*"));
    }
}
