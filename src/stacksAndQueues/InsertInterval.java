package stacksAndQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i = 0;

        while (i < intervals.length) {
            if (intervals[i][1] < newInterval[0]) {
                arrayList.add(intervals[i]);
            } else {
                break;
            }
            i++;
        }

        int[] toInsert = new int[2];
        if (i != intervals.length) {
            toInsert[0] = Math.min(newInterval[0], intervals[i][0]);
        } else {
            arrayList.add(newInterval);
            int[][] res = new int[arrayList.size()][2];
            arrayList.toArray(res);
            return res;
        }

        while (i < intervals.length) {
            if (newInterval[1] >= intervals[i][0]) {
                i++;
            } else {
                break;
            }
        }

        if (i != 0) {
            toInsert[1] = Math.max(newInterval[1], intervals[i - 1][1]);
        } else {
            toInsert[1] = newInterval[1];
        }
        arrayList.add(toInsert);

        while (i < intervals.length) {
            arrayList.add(intervals[i++]);
        }

        int[][] res = new int[arrayList.size()][2];
        arrayList.toArray(res);
        return res;
    }

    /*{
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i;
        for (i = 0; i < intervals.length; i++) {
            if (newInterval[0] >= intervals[i][1]) {
                arrayList.add(intervals[i]);
            } else {
                break;
            }
        }
        int[] toInsert = new int[2];
        if (i != intervals.length) {
            toInsert[0] = Math.min(newInterval[0], intervals[i][0]);
        } else {
            toInsert[0] = newInterval[0];
        }

        for (; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                break;
            }
        }
        if (i != intervals.length) {
            toInsert[1] = Math.max(intervals[i][1], newInterval[1]);
        } else {
            toInsert[1] = Math.max(intervals[i][1], newInterval[1]);
        }

        arrayList.add(toInsert);
        i++;
        for (; i < intervals.length; i++) {
            arrayList.add(intervals[i]);
        }

        int[][] res = new int[arrayList.size()][2];
        arrayList.toArray(res);
        return res;
    }*/

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insert(new int[][]{
                {1, 3},
                {6, 9},
//                {6, 7},
//                {8, 10},
//                {12, 16}
        }, new int[]{0,2})));
    }
}
