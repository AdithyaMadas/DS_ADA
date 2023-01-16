package stacksAndQueues;


import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class AsteroidCollision {

    static class Pair{
        int value, index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static int[] asteroidCollision(int[] a) {
        LinkedList<Integer> s = new LinkedList<>(); // use LinkedList to simulate stack so that we don't need to reverse at end.
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 || s.isEmpty() || s.getLast() < 0)
                s.add(a[i]);
            else if (s.getLast() <= -a[i]) {
                if (s.pollLast() < -a[i]) i--;
            }
        }
        return s.stream().mapToInt(i->i).toArray();
    }

    /*public static int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        int res[] = new int[asteroids.length];
        for (int i = 0; i < asteroids.length; i++) {
            res[i] = asteroids[i];
        }
        for (int i = asteroids.length - 1; i >= 0; i--) {
            if (asteroids[i] < 0) {
                stack.push(new Pair(asteroids[i], i));
            } else {
                while (!stack.isEmpty() && asteroids[i] > abs(stack.peek().value)) {
                    res[stack.pop().index] = 0;
                }
                if (!stack.isEmpty() && asteroids[i] == abs(stack.peek().value)) {
                    res[stack.pop().index] = 0;
                }
            }
        }
        stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) {
                stack.push(new Pair(asteroids[i], i));
            } else {
                while (!stack.isEmpty() && abs(asteroids[i]) > stack.peek().value) {
                    res[stack.pop().index] = 0;
                }
                if (!stack.isEmpty() && abs(asteroids[i]) == stack.peek().value) {
                    res[stack.pop().index] = 0;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i : res) {
            if (i != 0) {
                list.add(i);
            }
        }
        int[] ints =  list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return ints;
    }*/


    public static void main(String[] args) {
        System.out.println(Arrays.toString(asteroidCollision(new int[]{-2, 1, 2, 3, -2, -3})));
    }
}
