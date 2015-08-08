package median_of_two_sorted_array;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int count = m + n;
        int midRank = count >> 1;

        if ((count & 1) == 1) {
            int mid = findmMedianSortedArraysRecursively(nums1, 0, m, nums2, 0, n, midRank);
            return mid;
        }
        else {
            int mid1 = findmMedianSortedArraysRecursively(nums1, 0, m, nums2, 0, n, midRank - 1);
            int mid2 = findmMedianSortedArraysRecursively(nums1, 0, m, nums2, 0, n, midRank);
            return (mid1 + mid2) / 2.0;

        }
    }

    private static int findmMedianSortedArraysRecursively(int[] nums1, int begin1, int end1,
                                                             int[] nums2, int begin2, int end2,
                                                             int rank) {
        int m = end1 - begin1;
        int n = end2 - begin2;

        if(m == 0) return nums2[begin2 + rank];

        if(n == 0) return nums1[begin1 + rank];

        if(rank == 0) return nums1[begin1] < nums2[begin2] ? nums1[begin1] : nums2[begin2];

        int midRank = (rank - 1) >> 1;

        int rank1 = midRank < m ? midRank : m - 1;
        int rank2 = midRank < n ? midRank : n - 1;

        int i = nums1[begin1 + rank1];
        int j = nums2[begin2 + rank2];

        return i <= j ?
                findmMedianSortedArraysRecursively(nums1, begin1 + rank1 + 1, end1, nums2, begin2, end2, rank - rank1 - 1) :
                findmMedianSortedArraysRecursively(nums1, begin1, end1, nums2, begin2 + rank2 + 1, end2, rank - rank2 - 1);
    }
}