package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k) {
        int[] min = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        min[k - 1] = 0;

        ArrayList<int[]>[] arrayLists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            arrayLists[time[0] - 1].add(new int[]{time[1] - 1, time[2]});
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return min[o1] - min[o2];
            }
        });
        priorityQueue.offer(k - 1);

        while (!priorityQueue.isEmpty()) {
            Integer poll = priorityQueue.poll();
            for (int[] i : arrayLists[poll]) {
                if (i[1] + min[poll] < min[i[0]]) {
                    min[i[0]] = i[1] + min[poll];
                    priorityQueue.offer(i[0]);
                }
            }
        }
        int max = Arrays.stream(min).max().getAsInt();
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
        System.out.println(networkDelayTime(new int[][]{{1,2,1}}, 2, 1));
        System.out.println(networkDelayTime(new int[][]{{1,2,1}}, 2, 2));
    }
}
