package stacksAndQueues;

import java.util.*;

//https://www.youtube.com/watch?v=Ulb3ixSpE4Y
public class SumOfSubarrayMinimum {

    static class Pair {
        int ele, count;

        public Pair(int ele, int count) {
            this.ele = ele;
            this.count = count;
        }
    }

    public static int sumSubarrayMins(int[] arr) {
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];

        ArrayDeque<Pair> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek().ele > arr[i]) {
                count += stack.pop().count;
            }
            stack.push(new Pair(arr[i], count));
            left[i] = count;
        }
        stack = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek().ele >= arr[i]) {
                count += stack.pop().count;
            }
            stack.push(new Pair(arr[i], count));
            right[i] = count;
        }
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += (long) arr[i] * left[i] * right[i];
        }
        return (int) (sum % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{11, 81, 94, 43, 3}));
    }
}
