package stacksAndQueues;

import javax.sound.sampled.Line;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class StackImplementationWithQueue {

    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        for (int i=1; i<queue.size(); i++)
            queue.add(queue.remove());
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
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
