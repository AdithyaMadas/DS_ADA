package recursion;

import java.util.Stack;

public class ReverseStack {
    static void reverse(Stack<Integer> s) {
        if (s.size() == 0) {
            return;
        }
        Integer pop = s.pop();
        reverse(s);
        insertAtBottom(s, pop);
    }

    private static void insertAtBottom(Stack<Integer> s, Integer pop) {
        if (s.size() == 0) {
            s.push(pop);
        } else {
            Integer pop1 = s.pop();
            insertAtBottom(s, pop);
            s.push(pop1);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>() {{
            add(3);
            add(2);
            add(1);
            add(7);
            add(6);
        }};
        System.out.println(stack);
        reverse(stack);
        System.out.println(stack);
    }
}
