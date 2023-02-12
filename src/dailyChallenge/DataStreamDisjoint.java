package dailyChallenge;

import java.util.*;

public class DataStreamDisjoint {
    static class SummaryRanges {

        TreeSet<Integer> set;

        public SummaryRanges() {
            set = new TreeSet<>();
        }

        public void addNum(int value) {
            set.add(value);
        }


        public int[][] getIntervals() {
            if (set.size() == 0) {
                return new int[0][2];
            }
            List<int[]> list = new ArrayList<>();
            int left = -1, right = -1;
            for (int i : set) {
                if (left < 0) {
                    left = right = i;
                } else if (right == i - 1) {
                    right = i;
                } else {
                    list.add(new int[]{left, right});
                    left = right = i;
                }
            }
            list.add(new int[]{left, right});
            return list.toArray(new int[0][]);
        }

        public static void main(String[] args) {
            SummaryRanges ranges = new SummaryRanges();
            ranges.addNum(1);
            System.out.println(Arrays.deepToString(ranges.getIntervals()));
            ranges.addNum(3);
            System.out.println(Arrays.deepToString(ranges.getIntervals()));
            ranges.addNum(2);
            System.out.println(Arrays.deepToString(ranges.getIntervals()));
            ranges.addNum(5);
            System.out.println(Arrays.deepToString(ranges.getIntervals()));
            ranges.addNum(7);
            System.out.println(Arrays.deepToString(ranges.getIntervals()));
            ranges.addNum(6);
            System.out.println(Arrays.deepToString(ranges.getIntervals()));
        }
    }
}