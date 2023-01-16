package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> minNumbers = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> maxNumbers = new PriorityQueue<>();

    public MedianFinder() {
        minNumbers = new PriorityQueue<>(Comparator.reverseOrder());
        maxNumbers = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (minNumbers.size() == 0) {
            minNumbers.offer(num);
            return;
        }
        if (num > minNumbers.peek()) {
            maxNumbers.offer(num);
        }else {
            minNumbers.offer(num);
        }

        if (minNumbers.size() - maxNumbers.size() > 1) {
            maxNumbers.offer(minNumbers.poll());
        }
        if (maxNumbers.size() - minNumbers.size() > 1) {
            minNumbers.offer(maxNumbers.poll());
        }
    }

    public double findMedian() {
        if (maxNumbers.size() == minNumbers.size()) {
            return ((double) maxNumbers.peek() + minNumbers.peek()) / 2.0;
        } else if (maxNumbers.size() > minNumbers.size()) {
            return maxNumbers.peek();
        } else {
            return minNumbers.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }
}
