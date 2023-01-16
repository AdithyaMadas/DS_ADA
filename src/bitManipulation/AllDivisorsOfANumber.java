package bitManipulation;

import java.util.List;
import java.util.Stack;

public class AllDivisorsOfANumber {
    public static void print_divisors(int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                stack.push(i);
                System.out.printf(i + " ");
            }
        }
        if (stack.peek() * stack.peek() == n) {
            stack.pop();
        }
        while (!stack.isEmpty()) {
            System.out.printf(n / stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        print_divisors(25);
    }
}
