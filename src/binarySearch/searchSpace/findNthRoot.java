package binarySearch.searchSpace;

public class findNthRoot {

    public static int NthRoot(int n, int x) {
        if(x==1) return 1;
        int low = 0, high = x / n;
        while (low <= high) {
            int mid = (low + high) / 2;
            double pow = Math.pow(mid, n);
            if (pow == x) {
                return mid;
            }
            if (pow <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(NthRoot(3, 28));
    }
}
