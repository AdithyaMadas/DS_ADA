package stacksAndQueues;

import javax.sound.sampled.Line;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class StackImplementationWithQueue {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public StackImplementationWithQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        int size = queue1.size();
        for (int i = 0; i < size - 1; i++) {
            queue2.add(queue1.remove());
        }
        int x = queue1.remove();
        size = queue2.size();
        for (int i = 0; i < size; i++) {
            queue1.add(queue2.remove());
        }
        return x;
    }

    public int top() {
        int size = queue1.size();
        for (int i = 0; i < size - 1; i++) {
            queue2.add(queue1.remove());
        }
        int x = queue1.remove();
        queue2.add(x);
        size = queue2.size();
        for (int i = 0; i < size; i++) {
            queue1.add(queue2.remove());
        }
        return x;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackImplementationWithQueue stack = new StackImplementationWithQueue();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
