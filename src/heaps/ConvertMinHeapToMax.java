package heaps;

import java.util.Arrays;

public class ConvertMinHeapToMax {
    static void convertMinToMaxHeap(int N, int arr[]) {
        /*for (int i = N - 1; i > 0; i--) {
            shiftDown(arr, i, N);
        }*/

        for (int i = N / 2 - 1; i >= 0; i--) {

            shiftDown(arr, i, N);
//            maxify(arr, i);
        }
    }

    private static void shiftDown(int[] arr, int pos, int n) {
        int leftChild = getLeft(pos);
        int rightChild = getRight(pos);

        int largest = pos;
        if(leftChild<n && arr[leftChild]>arr[pos]) largest = leftChild;
        if(rightChild<n && arr[rightChild]>arr[pos]) largest = rightChild;

        if (pos == largest) {
            return;
        }

        exchange(arr, pos, largest);
        shiftDown(arr, largest, n);
    }

    private static void exchange(int[] arr, int pos, int smallest) {
        int tmp = arr[pos];
        arr[pos] = arr[smallest];
        arr[smallest] = tmp;
    }

    private static int getLeft(int i) {
        return (2 * i) + 1;
    }

    private static int getRight(int i) {
        return (2 * i) + 2;
    }

    static void maxify(int[] arr, int pos) {
        while (true) {
            int parent = getParent(pos);
            if (arr[parent] < arr[pos]) {
                int tmp = arr[parent];
                arr[parent] = arr[pos];
                arr[pos] = tmp;
            } else {
                break;
            }
            if (parent == 0) {
                break;
            }
            pos = parent;
        }
    }

    static int getParent(int i) {
        return (i - 1) / 2;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4};
        convertMinToMaxHeap(4, ints);
        System.out.println(Arrays.toString(ints));
    }
}
