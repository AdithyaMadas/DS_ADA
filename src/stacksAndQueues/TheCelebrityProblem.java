package stacksAndQueues;

import java.util.ArrayDeque;

public class TheCelebrityProblem {

    static int celebrity(int M[][], int n) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int a = stack.pop(), b = stack.pop();
            if (M[a][b] == 1) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }
        int ans = stack.pop();
        for (int i = 0; i < n; i++) {
            if (M[ans][i] == 1) {
                return -1;
            }
            if (M[i][ans] == 0) {
                if(i!=ans) return -1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(celebrity(new int[][]
                {{0, 1, 0},
                        {0, 0, 0},
                        {0, 1, 0}}, 3));
    }
}
