package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class nonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        int prevEnd = Integer.MIN_VALUE, ans = 0;
        for (int[] i : intervals) {
            if (i[0] < prevEnd) {
                ans++;
                prevEnd = Math.min(prevEnd, i[1]);
            } else {
                prevEnd = i[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]
                {{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}}
        ));
    }
}
