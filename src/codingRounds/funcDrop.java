package codingRounds;

import java.util.HashMap;

public class funcDrop {
    public static void  funcDrop(int[] xCoordinate, int[] yCoordinate) {
        HashMap<Integer, Integer> countX = new HashMap<>();
        HashMap<Integer, Integer> countY = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < xCoordinate.length; i++) {
            Integer eleCount = countX.getOrDefault(xCoordinate[i], 0) + 1;
            if (eleCount > maxCount) {
                maxCount = eleCount;
            }
            countX.put(xCoordinate[i], eleCount);
            eleCount = countY.getOrDefault(yCoordinate[i], 0) + 1;
            if (eleCount > maxCount) {
                maxCount = eleCount;
            }
            countY.put(yCoordinate[i], eleCount);
        }
        if(maxCount==1) maxCount = 0;
        System.out.println(maxCount);
    }


    public static void main(String[] args) {
        funcDrop(new int[]{2, 3, 2, 4, 2}, new int[]{2, 2, 6, 5, 8});
    }
}
