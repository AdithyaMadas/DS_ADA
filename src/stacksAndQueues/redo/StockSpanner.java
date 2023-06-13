package stacksAndQueues.redo;

import java.util.Stack;

public class StockSpanner {

    class Pair {
        int price, count;

        public Pair(int price, int count) {
            this.price = price;
            this.count = count;
        }
    }
    Stack<Pair> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && price >= stack.peek().price) {
            count += stack.pop().count;
        }
        stack.add(new Pair(price, count));
        return count;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
    }
}
