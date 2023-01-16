package binarySearch;

//https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?track=DSASP-Searching&amp%3BbatchId=154&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-a-sorted-array
public class FloorOfArray {
    static int findFloor(long nums[], int n, long target) {
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0) {
            return -1;
        } else {
            return (right + left) / 2;
        }
    }

    public static void main(String[] args) {
        long[] arr = {1, 2, 8, 10, 11, 12, 19};
        System.out.println(findFloor(arr, arr.length, 0));
    }
}
