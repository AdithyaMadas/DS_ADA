package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JobScheduling {

    static class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }


    static int[] JobScheduling(Job arr[], int n) {
        int[] slots = new int[arr.length];
        Arrays.fill(slots, 0);
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit - o1.profit;
            }
        });
        int jobs = 0, profit = 0;
        for (Job j : arr) {
            int slot = j.deadline - 1;
            while (slot >= 0 && slots[slot] != 0) {
                slot--;
            }
            if (slot == -1) {
                continue;
            }
            slots[slot] = 1;
            profit += j.profit;
            jobs++;
        }
        return new int[]{jobs, profit};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(JobScheduling(new Job[]{
                new Job(1, 4, 20),
                new Job(2, 1, 10),
                new Job(3, 1, 40),
                new Job(4, 1, 30)
        }, 4)));
    }
}
