package stacksAndQueues;

import java.util.ArrayDeque;

public class StockSpanner {

    class Pair{
        int ele, count;

        public Pair(int ele, int count) {
            this.ele = ele;
            this.count = count;
        }
    }

    ArrayDeque<Pair> stack;
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int count = 1;
        while (!stack.isEmpty() && price >= stack.peek().ele) {
            count += stack.pop().count;
        }
        stack.push(new Pair(price, count));
        return count;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100));
        System.out.println(stockSpanner.next(80));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(70));
        System.out.println(stockSpanner.next(60));
        System.out.println(stockSpanner.next(75));
        System.out.println(stockSpanner.next(85));
    }
}
