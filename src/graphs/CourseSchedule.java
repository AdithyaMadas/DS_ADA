//package graphs;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//
//public class CourseSchedule {
//    public static int[] findOrder(int numCourses, int[][] prerequisites) {
//        HashMap<Integer, List<Integer>> preReq = new HashMap<>();
//        for (int[] i : prerequisites) {
//            preReq.computeIfAbsent(i[0], (v) -> new ArrayList<Integer>()).add(i[1]);
//        }
//        for (int i = 0; i < numCourses; i++) {
//
//        }
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));
//        System.out.println(Arrays.toString(findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
//    }
//}
