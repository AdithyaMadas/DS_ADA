package heaps;

import java.util.*;

public class MaxSumCombination {

    static class Addition implements Comparable<Addition> {
        int sum, i, j;

        public Addition(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }


        @Override
        public int compareTo(Addition o) {
            return o.sum - sum;
        }
    }

    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<Addition> pq = new PriorityQueue<>();
        for (int i = N - 1; i >= 0; i--) {
            pq.offer(new Addition(A[i] + B[N - 1], i, N - 1));
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!pq.isEmpty() && K-- > 0) {
            Addition poll = pq.poll();
            arrayList.add(poll.sum);
            if (poll.j != 0) {
                pq.offer(new Addition(A[N - 1] + B[poll.j - 1], N - 1, poll.j - 1));
            }
        }
        return arrayList;
    }


    public static void main(String[] args) {
        System.out.println(maxCombinations(4, 3, new int[]{1, 4, 2, 3}, new int[]{2, 5, 1, 6}));
    }
}
