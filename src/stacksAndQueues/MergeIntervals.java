package stacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, ((o1, o2) -> Integer.compare(o1[0], o2[0])));
        int[] newInterval = intervals[0];
        list.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                list.add(newInterval);
            }
        }
        return list.toArray(new int[0][]);
    }

//    public static int[][] merge(int[][] intervals) {
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) {
//                    return o1[1] - o2[1];
//                }
//                return o1[0] - o2[0];
//            }
//        });
//        LinkedList<int[]> list = new LinkedList<>();
//        for (int i = 0; i < intervals.length; i++) {
//            list.add(intervals[i]);
//            int max = list.peekLast()[1];
//            while (i < intervals.length) {
//                if (max >= intervals[i][0]) {
//                    i++;
//                    max = Math.max(max, intervals[i - 1][1]);
//                } else {
//                    break;
//                }
//            }
//            int[] ints = list.removeLast();
//            ints[1] = max;
//            list.add(ints);
//            i--;
//        }
//        int[][] arr = new int[list.size()][2];
//        list.toArray(arr);
//        return arr;
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
//                {1, 4}, {0,2}, {3,5}
//                {1, 4}, {4, 5}
//                {2,2},{1,3},{3,3},{3,4},{2,3},{4,5},{4,4}
//                {0,0},{1,2},{5,5},{2,4},{3,3},{5,6},{5,6},{4,6},{0,0},{1,2},{0,2},{4,5}
//                {1, 3}, {0, 2}, {2, 3}, {4, 6}, {4, 5}, {5, 5}, {0, 2}, {3, 3}
        })));
    }
}
