package bitManipulation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CountPrimes {
    public static int countPrimes(int n) {
        int count = 0;
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, true);
        for (int i = 2; i < n; i++) {
            if (arr[i]) {
                count++;
                for (long j = (long) i * i; j < n; j+=i) {
                    arr[(int) j] = false;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(1));
    }
}
