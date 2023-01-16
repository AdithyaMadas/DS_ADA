package bitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintPrimes {
    public static int[] AllPrimeFactors(int N) {
        if (N == 1) {
            return new int[]{};
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                list.add(i);
                while (N % i == 0) {
                    N /= i;
                }
            }
        }
        if (N > 1) {
            list.add(N);
        }
        int[] ints =  list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return ints;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(AllPrimeFactors(1)));
    }
}
