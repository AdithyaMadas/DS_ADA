package stacksAndQueues;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, rain = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    rain += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    rain += rightMax - height[right];
                }
                right--;
            }
        }
        return rain;
    }

    /*public static int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        int max = 0;
        for (int i = 0; i < height.length; i++) {
            maxLeft[i] = max;
            if (height[i] > max) {
                max = height[i];
            }
        }

        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            maxRight[i] = max;
            if (height[i] > max) {
                max = height[i];
            }
        }
        int rain = 0;
        for (int i = 0; i < height.length; i++) {
            rain += Math.max(0, Math.min(maxLeft[i], maxRight[i]) - height[i]);
        }
        return rain;
    }*/

    public static void main(String[] args) {
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
