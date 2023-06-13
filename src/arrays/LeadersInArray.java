package arrays;

import java.util.ArrayList;
import java.util.LinkedList;


//https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=leaders-in-an-array
public class LeadersInArray {


    static ArrayList<Integer> leaders(int arr[], int n) {
        int greatestTillNow = Integer.MIN_VALUE;
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= greatestTillNow) {
                greatestTillNow = arr[i];
                res.addFirst(arr[i]);
            }
        }
        return new ArrayList<>(res);
    }

//
//    public static void reverse(ArrayList<Integer> arrayList) {
//        int start = 0, end = arrayList.size() - 1;
//        while (start < end) {
//            java.util.Collections.swap(arrayList, start++, end--);
//        }
//    }
//    public static ArrayList<Integer> leaders(int arr[], int n) {
//        ArrayList<Integer> toReturn = new ArrayList<>();
//        int max = Integer.MIN_VALUE;
//        for (int i = arr.length - 1; i >= 0; i--) {
//            if (arr[i] >= max) {
//                toReturn.add(arr[i]);
//                max = arr[i];
//            }
//        }
//        reverse(toReturn);
//        return toReturn;
//    }

    public static void main(String[] args) {
        System.out.println(leaders(new int[]{16, 17, 4, 3, 5, 2}, 6));
    }

}
