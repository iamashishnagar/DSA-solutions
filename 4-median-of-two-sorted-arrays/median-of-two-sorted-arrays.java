class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0 && n == 0) return 0.0;
        if(m > n) return findMedianSortedArrays(nums2, nums1);

        int total = m + n;
        int half = (total + 1) / 2;
        int left = 0, right = m;

        while(left <= right){
            int mid1 = left + (right - left) / 2;
            int mid2 = half - mid1;

            int left1Max = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int left2Max = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int right1Min = mid1 == m ? Integer.MAX_VALUE : nums1[mid1];
            int right2Min = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];

            if(left1Max <= right2Min && left2Max <= right1Min){
                if(total % 2 == 0)
                    return (Math.max(left1Max, left2Max) + Math.min(right1Min, right2Min)) / 2.0;
                else return Math.max(left1Max, left2Max);
            }
            else if(left1Max > right2Min) right = mid1 - 1;
            else left = mid1 + 1;

        }

        return 0.0;
    }
}