package stacksAndQueues;

import java.util.Stack;

public class PrefixToPostFix {
    static String preToPost(String pre_exp) {
        int len = pre_exp.length();
        Stack<String> stack = new Stack<>();
        while (len-- > 0) {
            char c = pre_exp.charAt(len);
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                stack.push(stack.pop() + stack.pop() + c);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(preToPost("*-A/BC-/AKL"));

    }
}
