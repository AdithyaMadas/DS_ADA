package stacksAndQueues;

import java.util.Arrays;

public class NumberOfNGEToRight {
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        for (int i = 0; i < queries; i++) {
            indices[i] = getCount(N, arr, indices[i]);
        }
        return indices;
    }

    private static int getCount(int n, int[] arr, int index) {
        int count = 0, ele = arr[index];
        for (int i = n - 1; i > index; i--) {
            if (arr[i] > ele) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(count_NGEs(8, new int[]{3, 4, 2, 7, 5, 8, 10, 6}, 2, new int[]{0, 5})));
    }
}
