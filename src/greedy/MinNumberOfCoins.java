package greedy;

import java.util.ArrayList;
import java.util.List;

public class MinNumberOfCoins {
    static List<Integer> minPartition(int N) {
        int[] denominations = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < denominations.length && N > 0) {
            int noOfNotes = N / denominations[i];
            N -= denominations[i] * noOfNotes;
            while (noOfNotes > 0) {
                res.add(denominations[i]);
                noOfNotes--;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minPartition(1000));
    }
}
