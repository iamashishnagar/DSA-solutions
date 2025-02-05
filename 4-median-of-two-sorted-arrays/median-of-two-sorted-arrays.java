class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int leftHalf = (m + n + 1) / 2;
        int left = 0, right = m;

        while(left <= right){
            int mid1 = left + (right - left) / 2;
            int mid2 = leftHalf - mid1;

            int maxLeft1 = mid1 > 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int minRight1 = mid1 < m ? nums1[mid1] : Integer.MAX_VALUE;
            int maxLeft2 = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int minRight2 = mid2 < n ? nums2[mid2] : Integer.MAX_VALUE;

            if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
                return (m + n) % 2 != 0
                    ? Math.max(maxLeft1, maxLeft2)
                    : (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
            }
            else if(maxLeft1 > minRight2) right = mid1 - 1;
            else left = mid1 + 1;
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}