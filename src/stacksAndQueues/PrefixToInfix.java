package stacksAndQueues;

import java.util.Stack;

public class PrefixToInfix {
    static String preToInfix(String pre_exp) {
        int len = pre_exp.length();
        Stack<String> stack = new Stack<>();
        while (len-- > 0) {
            char c = pre_exp.charAt(len);
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                stack.push("(" + stack.pop() + c + stack.pop() + ")");
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(preToInfix("*-A/BC-/AKL"));
    }
}
