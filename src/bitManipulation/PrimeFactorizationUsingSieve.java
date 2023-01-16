package bitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactorizationUsingSieve {

    static int[] sieve;

    static void sieve() {
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]==-1) {
                for (long j = (long) i * i; j < sieve.length; j += i) {
                    if(sieve[(int) j]==-1) sieve[(int) j] = i;
                }
            }
        }
    }

    static List<Integer> findPrimeFactors(int N) {
        if (N == 1) {
            return new ArrayList<>();
        }
        sieve = new int[N + 1];
        Arrays.fill(sieve, -1);
        List<Integer> list = new ArrayList<>();
        sieve();

        while (sieve[N] != -1) {
            list.add(sieve[N]);
            N /= sieve[N];
        }
        list.add(N);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findPrimeFactors(1));
    }
}
