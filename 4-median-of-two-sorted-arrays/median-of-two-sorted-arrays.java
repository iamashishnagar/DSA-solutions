class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int m = nums1.length, n = nums2.length;
        int leftHalf = (m + n + 1) / 2;
        int left = 0, right = m;

        while(left <= right){
            int mid1 = left + (right - left) / 2;
            int mid2 = leftHalf - mid1;

            int left1Max = mid1 > 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int left2Max = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int right1Min = mid1 < m ? nums1[mid1] : Integer.MAX_VALUE;
            int right2Min = mid2 < n ? nums2[mid2] : Integer.MAX_VALUE;

            if(left1Max <= right2Min && left2Max <= right1Min)
                return (m + n) % 2 != 0
                    ? Math.max(left1Max, left2Max)
                    : (Math.max(left1Max, left2Max) + Math.min(right1Min, right2Min)) / 2.0;
            else if(left1Max > right2Min)
                right = mid1 - 1;
            else left = mid1 + 1;
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}