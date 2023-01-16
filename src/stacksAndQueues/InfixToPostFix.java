package stacksAndQueues;

import java.util.List;
import java.util.Stack;

public class InfixToPostFix {
    public static String infixToPostfix(String exp) {
        Stack<Character> operators = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for (char c : exp.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                postfix.append(c);
            } else {
                pushOnTopOfStack(operators, postfix, c);
            }
        }
        while (!operators.isEmpty()) {
            postfix.append((operators.peek() != '(' || operators.peek() != ')') ? operators.pop() : "");
        }
        return postfix.toString();
    }

    private static void pushOnTopOfStack(Stack<Character> operators, StringBuilder postfix, char c) {
        if (c == ')') {
            while (true) {
                Character pop = operators.pop();
                if(pop=='(') break;
                postfix.append(pop);
            }
            return;
        }
        if (operators.isEmpty() || operators.peek() == '(' || c == '(') {
            operators.push(c);
            return;
        }
        if (greaterPrecedence(operators.peek(), c)) {
            operators.push(c);
        } else {
            while (!operators.isEmpty() && !greaterPrecedence(operators.peek(), c)) {
                postfix.append(operators.pop());
            }
            operators.push(c);
        }
    }

    private static boolean greaterPrecedence(Character peek, char c) {
        if(c=='('||peek=='(') return true;
        if (c == '^') {
            return true;
        } else if (c == '*' || c == '/') {
            return peek != '^';
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }
}
