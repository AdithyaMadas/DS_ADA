package arrays;

import java.util.HashMap;

public class XORSubset {
    static int subsetXOR(int arr[], int N, int K) {
        int count = 0, xor = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            xor ^= arr[i];
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        xor = 0;
        for (int i = 0; i < N; i++) {
            xor ^= arr[i];
            if (arr[i] == K) {
                count++;
            }
            count += map.getOrDefault(xor ^ K, 0);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subsetXOR(new int[]{1,2,3,4,5}, 5, 4));
    }
}
