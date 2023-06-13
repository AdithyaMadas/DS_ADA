package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        ArrayList<Integer>[] arrayLists = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            arrayLists[i] = new ArrayList<Integer>();
        }
        for (int[] i : prerequisites) {
            arrayLists[i[1]].add(i[0]);
            inDegree[i[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            res[index++] = poll;
            for (int i : arrayLists[poll]) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
    }
}
