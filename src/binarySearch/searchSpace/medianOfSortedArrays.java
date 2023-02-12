package binarySearch.searchSpace;

public class medianOfSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0, high = nums1.length;
        int n = (nums2.length + nums1.length + 1) / 2;
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = n - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int r1 = cut1 == nums1.length ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == nums2.length ? Integer.MAX_VALUE : nums2[cut2];

            if (l1 > r2) {
                high = cut1 - 1;
            } else if (l2 > r1) {
                low = cut1 + 1;
            } else {
                if ((nums2.length + nums1.length) % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    }
}
