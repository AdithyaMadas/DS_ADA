package arrays;

public class CountInversions {
    static long ans;
    static long inversionCount(long arr[], long N) {
        ans = 0;
        mergeSort(arr,N);
        return ans;
    }

    public static void mergeSort(long[] a, long n) {
        if (n < 2) {
            return;
        }
        long mid = n / 2;
        long[] l = new long[(int) mid];
        long[] r = new long[(int) (n - mid)];

        for (long i = 0; i < mid; i++) {
            l[(int) i] = (int) a[(int) i];
        }
        for (long i = mid; i < n; i++) {
            r[(int) (i - mid)] = a[(int) i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    private static void merge(long[] arr, long[] left, long[] right, long lSize, long rSize) {
        double i = 0, l = 0, r = 0;
        while (l < lSize && r < rSize) {
            if (left[(int) l] <= right[(int) r]) {
                arr[(int) i++] = left[(int) l++];
            } else {
                ans += lSize - l;
                arr[(int) i++] = right[(int) r++];
            }
        }

        while (l < lSize) {
            arr[(int) i++] = left[(int) l++];
        }

        while (r < rSize) {
            arr[(int) i++] = right[(int) r++];
        }
    }


    public static void main(String[] args) {
        System.out.println(inversionCount(new long[]{11,10,10}, 3));
    }
}
