package graphs;

import com.sun.org.apache.xpath.internal.objects.XNull;

import java.util.ArrayList;
import java.util.List;

public class canFinish {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] child = new ArrayList[numCourses];
        for (int[] pre : prerequisites) {
            if (child[pre[1]] == null) {
                child[pre[1]] = new ArrayList<>();
            }
            child[pre[1]].add(pre[0]);
        }

        int[] vis = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (isCycle(child, i, vis)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCycle(List<Integer>[] child, int i, int[] vis) {
        if (vis[i] == 1) {
            return true;
        }
        if (vis[i] == 2) {
            return false;
        }
        if (vis[i] == 0) {
            vis[i] = 1;
            if (child[i] != null) {
                for (int chi : child[i]) {
                    if (isCycle(child, chi, vis)) {
                        return true;
                    }
                }
            }
            vis[i] = 2;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(canFinish(4, new int[][]{{2, 0}, {1, 0}, {3, 1}, {3, 2}, {1, 3}}));
    }
}
