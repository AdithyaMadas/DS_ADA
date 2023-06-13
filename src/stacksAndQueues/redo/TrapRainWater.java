package stacksAndQueues.redo;

public class TrapRainWater {
    public static int trap(int[] height) {
        int rain = 0;
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (leftMax <= height[left]) {
                    leftMax = height[left];
                } else {
                    rain += leftMax - height[left];
                }
                left++;
            } else {
                if (rightMax <= height[right]) {
                    rightMax = height[right];
                } else {
                    rain += rightMax - height[right];
                }
                right--;
            }
        }
        return rain;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
