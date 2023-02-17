package recursion;

import java.util.ArrayList;

public class SubsetSum {

    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(res, arr, 0, 0);
        return res;
    }

    private static void helper(ArrayList<Integer> res, ArrayList<Integer> arr, int currSum, int index) {
        if (index == arr.size()) {
            res.add(currSum);
            return;
        }
        helper(res, arr, currSum + arr.get(index), index + 1);
        helper(res, arr, currSum, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(subsetSums(new ArrayList<Integer>() {{
            add(2);
            add(3);
        }}, 2));
    }
}
