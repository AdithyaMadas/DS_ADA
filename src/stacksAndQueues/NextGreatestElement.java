package stacksAndQueues;

import java.util.*;

public class NextGreatestElement {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> posMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            posMap.put(nums1[i], i);
        }
        Stack<Integer> monotonicStack = new Stack<>();
        Arrays.fill(nums1, -1);
        for (int i : nums2) {
            if (monotonicStack.isEmpty() || monotonicStack.peek() > i) {
                monotonicStack.push(i);
            } else {
                while (!monotonicStack.isEmpty() && monotonicStack.peek() < i) {
                    int ele = monotonicStack.pop();
                    if (posMap.containsKey(ele)) {
                        nums1[posMap.get(ele)] = i;
                    }
                }
                if (posMap.containsKey(i)) {
                    monotonicStack.push(i);
                }
            }
        }
        return nums1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
