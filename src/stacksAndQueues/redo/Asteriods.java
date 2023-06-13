package stacksAndQueues.redo;

import java.util.Arrays;
import java.util.Stack;

public class Asteriods {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            if (i > 0) {
                stack.add(i);
            } else {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.add(i);
                } else {
                    boolean toAdd = true;
                    while (!stack.isEmpty() && stack.peek() > 0) {
                        int pop = stack.pop();
                        if (pop + i < 0) {
                            continue;
                        } else if (pop + i == 0) {

                            toAdd = false;
                            break;
                        } else {
                            stack.add(pop);
                            toAdd = false;
                            break;
                        }
                    }
                    if(toAdd) stack.add(i);
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{5, -5})));
        System.out.println(Arrays.toString(asteroidCollision(new int[]{10, 2, -5})));
    }
}
