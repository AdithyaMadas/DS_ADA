package stacksAndQueues;

import java.util.Stack;

public class QueueImplementationWithStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public QueueImplementationWithStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        int x = -1;
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        x = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack1.pop());
        }
        return x;
    }

    public int peek() {
        int x = -1;
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        x = stack2.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack1.pop());
        }
        return x;
    }

    public boolean empty() {
        return stack1.isEmpty();
    }

    public static void main(String[] args) {

    }
}
