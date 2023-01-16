package greedy;

import java.util.*;

public class NumberOfPlatforms {
    static class TrainEvent implements Comparable<TrainEvent>{
        int time;
        boolean arrival;

        public TrainEvent(int time, boolean arrival) {
            this.time = time;
            this.arrival = arrival;
        }

        @Override
        public int compareTo(TrainEvent o) {
            if (o.time == time) {
                if (o.arrival) {
                    return 1;
                } else if (arrival) {
                    return -1;
                }
            }
            return time - o.time;
        }
    }
    static int findPlatform(int arr[], int dep[], int n) {
        PriorityQueue<TrainEvent> heap = new PriorityQueue<>();
        for (int i : arr) {
            heap.offer(new TrainEvent(i, true));
        }
        for (int i : dep) {
            heap.offer(new TrainEvent(i, false));
        }
        int currTrain = 0, maxTrain = 0;
        while (!heap.isEmpty()) {
            TrainEvent poll = heap.poll();
            if (poll.arrival) {
                currTrain++;
            } else {
                currTrain--;
            }
            if (currTrain > maxTrain) {
                maxTrain = currTrain;
            }
        }
        return maxTrain;
    }

    public static void main(String[] args) {
        System.out.println(findPlatform(new int[]{900, 940, 950, 1100, 1500, 1800}, new int[]{910, 1200, 1120, 1130, 1900, 2000}, 6));
    }
}
