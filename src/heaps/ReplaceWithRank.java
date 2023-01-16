package heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.PriorityQueue;

public class ReplaceWithRank {

    static class Pair implements Comparable<Pair>{
        int index, value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }
    static int[] replaceWithRank(int arr[], int N) {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.offer(new Pair(i, arr[i]));
        }
        int rank = 1, lastValue = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            if (poll.value == lastValue) {
                rank--;
            }
            arr[poll.index] = rank++;
            lastValue = poll.value;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = {2,2, 20, 10, 3, 14, 16, 14};
        System.out.println(Arrays.toString(replaceWithRank(ints, ints.length)));
    }
}
