package heaps;

import javax.xml.bind.Element;
import java.util.*;

public class TopKFrequentElements {

    static class Element implements Comparable<Element> {
        int num, count;

        public Element(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Element o) {
            return o.count - count;
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
        }
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Element(entry.getKey(), entry.getValue()));
        }
        int[] res = new int[k];
        while (--k >= 0 && !pq.isEmpty()) {
            res[k] = pq.poll().num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
