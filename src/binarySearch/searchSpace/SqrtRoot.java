package binarySearch.searchSpace;

public class SqrtRoot {
    static long floorSqrt(long x) {
        if(x==1) return 1;
        long low = 0, high = x / 2;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid * mid <= x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    public static void main(String[] args) {
        System.out.println(floorSqrt(1));
    }
}
