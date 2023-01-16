package strings;

import java.util.Stack;

public class RemoveOuterParanthesis {

    public static String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder toReturn = new StringBuilder();
        for (char i : s.toCharArray()) {
            if (i == 40) {
                stack.push(i);
                if (stack.size() > 1) {
                    toReturn.append("(");
                }
            }
            if (i == 41) {
                if (stack.size() != 1) {
                    toReturn.append(")");
                }
                stack.pop();
            }
        }
        return toReturn.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("()()"));
    }
}
