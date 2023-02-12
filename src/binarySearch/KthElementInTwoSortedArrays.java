package binarySearch;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthElementInTwoSortedArrays {
    public static long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : arr1) {
            heap.offer(i);
            if (heap.size() > (k)) {
                heap.poll();
            }
        }
        for (int i : arr2) {
            heap.offer(i);
            if (heap.size() > (k)) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        System.out.println(kthElement(new int[]{100, 112, 256, 349, 770 }, new int[]{72, 86, 113, 119, 265, 445, 892}, 5, 4, 7));
    }
}
