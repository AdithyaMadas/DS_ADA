package heaps;

public class IsItAMinHeap {
    public static boolean countSub(long arr[], long n) {
        return isMinHeap(arr, 0, n);
    }

    public static boolean isMinHeap(long arr[], int i, long len) {
        if(i>=len) return true;
        int left = getLeftChild(i), right = getRightChild(i);
        if(left<len && arr[i]<arr[left]) return false;
        if(right<len && arr[i]<arr[right]) return false;
        return isMinHeap(arr, left, len) && isMinHeap(arr, right, len);
    }

    private static int getLeftChild(int i) {
        return (2 * i) + 1;
    }

    private static int getRightChild(int i) {
        return (2 * i) + 2;
    }

    public static void main(String[] args) {
        System.out.println(countSub(new long[]{9, 15, 10, 7, 12, 11}, 6));
    }
}
