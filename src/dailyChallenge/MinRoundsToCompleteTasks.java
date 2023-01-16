package dailyChallenge;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/
public class MinRoundsToCompleteTasks {
    public static int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);
        int res = 0;
        int i = 0;
        while (i < tasks.length) {
            int j = i + 1;
            while (tasks[i] == tasks[j]) {
                j++;
            }
            if(i==j-1) return -1;
            res += computeSum(i, j);
            i = j;
        }
        return res;
    }

    private static int computeSum(int i, int j) {
        int numOfEle = (j - i);
        if (numOfEle % 3 == 0) return numOfEle / 3;
        if(numOfEle%3==1) return ((numOfEle - 4) / 3) + 2;
        else return ((numOfEle - 2) / 3) + 1;
    }

//    public static int minimumRounds(int[] tasks) {
//        int count = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i : tasks) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        for (int i : map.values()) {
//            if (i == 1) {
//                return -1;
//            }
//            if (i == 2) {
//                count++;
//            } else if (i == 4) {
//                count += 2;
//            } else if (i % 3 == 0) {
//                count += (i / 3);
//            } else if (i % 3 == 1) {
//                count += 2;
//                count += (i - 4) / 3;
//            } else if (i % 3 == 2) {
//                count++;
//                count += (i - 2) / 3;
//            }
//        }
//        return count;
//    }

    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[]{2, 3, 3, 2}));
    }
}
