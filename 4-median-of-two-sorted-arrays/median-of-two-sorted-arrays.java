class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if(length1 > length2)
            return findMedianSortedArrays(nums2, nums1);
        
        int total = length1 + length2;
        int half = (total + 1) / 2;

        int left = 0, right = length1;

        while(left <= right){
            int mid1 = left + (right - left) / 2;
            int mid2 = half - mid1;

            int left1 = mid1 > 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
            int left2 = mid2 > 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
            int right1 = mid1 < length1 ? nums1[mid1] : Integer.MAX_VALUE;
            int right2 = mid2 < length2 ? nums2[mid2] : Integer.MAX_VALUE;

            if(left1 <= right2 && left2 <= right1){
                if(total % 2 == 0)
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                else
                    return Math.max(left1, left2);
            }
            else if(left1 > right2) right = mid1 - 1;
            else left = mid1 + 1;
        }

        return 0.0;
    }
}