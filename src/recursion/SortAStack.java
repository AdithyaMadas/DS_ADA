package recursion;

import java.util.Stack;

public class SortAStack {
    public static Stack<Integer> sort(Stack<Integer> s) {
        if (s.size() > 0) {
            int x = s.pop();
            sort(s);
            sortedInsert(s, x);
        }
        return s;
    }

    private static void sortedInsert(Stack<Integer> s, int x) {
        if (s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }
        int ele = s.pop();
        sortedInsert(s, x);
        s.push(ele);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(41);
        stack.push(3);
        stack.push(32);
        stack.push(2);
        stack.push(11);
        System.out.println(sort(stack));
    }
}
