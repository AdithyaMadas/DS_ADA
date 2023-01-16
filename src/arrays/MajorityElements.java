package arrays;

public class MajorityElements {
    public static int majorityElement(int[] nums) {
        int count = 1, maxElement = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i == maxElement) {
                count++;
                if (count > nums.length / 2) {
                    return maxElement;
                }
            } else {
                count--;
                if (count == 0) {
                    maxElement = i;
                    count++;
                }
            }
        }
        return maxElement;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }
}
