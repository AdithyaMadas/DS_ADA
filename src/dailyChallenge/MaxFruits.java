package dailyChallenge;

import java.util.HashMap;
import java.util.HashSet;

public class MaxFruits {

    public static int totalFruit(int[] fruits) {
        int fruit1 = fruits[0], fruit2 = -1, left = 0, res = 0, right;
        for (right = 0; right < fruits.length; right++) {
            int fruit = fruits[right];
            if (fruit != fruit1 && fruit != fruit2) {
                if (fruit2 == -1) {
                    fruit2 = fruit;
                    continue;
                }
                res = Math.max(res, right - left);
                left = right - 1;
                int prevFr = fruits[left];
                while (fruits[left] == prevFr) {
                    left--;
                }
                left++;
                fruit1 = prevFr;
                fruit2 = fruit;
            }
        }
        return Math.max(res, right - left);
    }

//    public static int totalFruit(int[] fruits) {
//        int left = 0, right = 0, maxLen = 0;
//        HashMap<Integer, Integer> map = new HashMap<>();
//        while (right != fruits.length) {
//            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
//            while (map.size() > 2) {
//                map.put(fruits[left], map.get(fruits[left]) - 1);
//                if(map.get(fruits[left]) == 0) map.remove(fruits[left]);
//                left++;
//            }
//            right++;
//            maxLen = Math.max(maxLen, right - left);
//        }
//        return maxLen;
//    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 0}));
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(totalFruit(new int[]{1, 2, 1}));
        System.out.println(totalFruit(new int[]{0,1, 2, 2}));
    }
}
