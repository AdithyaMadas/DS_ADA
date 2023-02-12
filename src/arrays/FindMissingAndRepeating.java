package arrays;

import java.util.Arrays;
import java.util.Map;

public class FindMissingAndRepeating {
    static int[] findTwoElement(int arr[], int n) {
        int[] ans = new int[2];
        for (int i : arr) {
            int abs = Math.abs(i);
            if (arr[abs - 1] > 0) {
                arr[abs - 1] = -arr[abs - 1];
            } else {
                ans[0] = abs;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0) ans[1] = i + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTwoElement(new int[]{1, 3, 3}, 3)));
    }
}
