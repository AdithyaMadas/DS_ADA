package dailyChallenge;

import java.util.Arrays;

public class ShuffleArray {

    // O(1) space
    public static int[] shuffle(int[] nums, int n) {
        for (int i = n; i < nums.length; i++) {
            nums[i] = nums[i] << 10 | nums[i - n];
        }
        int index = 0;
        int allOnes = (1 << 10) - 1;
        for (int i = n; i < nums.length; i++) {
            nums[index] = nums[i] & allOnes;
            nums[index + 1] = nums[i] >> 10;
            index += 2;
        }
        return nums;
    }


//    O(n) Space
//    public static int[] shuffle(int[] nums, int n) {
//        int[] arr = new int[2 * n];
//        for (int i = 0, j = n, k = 0; j < nums.length; i++, j++, k += 2) {
//            arr[k] = nums[i];
//            arr[k + 1] = nums[j];
//        }
//        return arr;
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)));
    }
}
