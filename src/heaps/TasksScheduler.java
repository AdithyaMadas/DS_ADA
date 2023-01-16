package heaps;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TasksScheduler {
    //https://leetcode.com/problems/task-scheduler/solutions/104500/java-o-n-time-o-1-space-1-pass-no-sorting-solution-with-detailed-explanation/?orderBy=most_votes
    public static int leastInterval(char[] tasks, int n) {
        int[] charCount = new int[26];
        int max = 0, maxCount = 0;
        for (char c : tasks) {
            int count = ++charCount[c - 'A'];
            if (count == max) {
                maxCount++;
            }
            if (count > max) {
                max = count;
                maxCount = 1;
            }
        }

        int emptySlots = (n - maxCount + 1) * max - 1;
        int availableTasks = tasks.length - maxCount * max;
        int idles = Math.max(0, emptySlots - availableTasks);
        System.out.println(emptySlots);
        System.out.println(availableTasks);
        System.out.println(idles);

        return tasks.length + idles;
    }
    /*public static int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i : map.values()) {
            queue.offer(i);
        }
        int ans = 0, q = n + 1;
        while (!queue.isEmpty()) {
            int[] count = new int[q];
            while (!queue.isEmpty() && q > 0) {
                count[--q] = queue.poll();
            }
            ans += n + 1;
            int empty = q;
            while (q < count.length) {
                int c = count[q];
                q++;
                if (--c == 0) {
                    continue;
                }
                queue.add(c);
            }
            if (queue.size() == 0) {
                ans -= empty;
            }
            q = n + 1;
        }
        return ans;
    }*/

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
