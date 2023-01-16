package binarySearch;

import javafx.util.Pair;

//https://practice.geeksforgeeks.org/problems/ceil-the-floor2802/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=ceil-the-floor
public class CeilTheFloor {
    static Pair getFloorAndCeil(int[] arr, int n, int x) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i < x && i > max) {
                max = i;
            }
            if (i > x && i < min) {
                min = i;
            }
        }
        if(max==Integer.MIN_VALUE) max = -1;
        if(min==Integer.MAX_VALUE) min = -1;
        return new Pair(max, min);
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 8, 9, 6, 5, 5, 6};
        System.out.println(getFloorAndCeil(arr, arr.length, 10));
    }
}
