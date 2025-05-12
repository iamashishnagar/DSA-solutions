class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if(m > n) return findMedianSortedArrays(nums2, nums1);

        int totalLength = m + n;
        int leftHalf = (totalLength + 1) / 2;
        int left = 0, right = m;

        while(left <= right){
            int mid1 = left + (right - left) / 2;
            int mid2 = leftHalf - mid1;

            int leftMax1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int rightMin1 = mid1 == m ? Integer.MAX_VALUE : nums1[mid1];
            int leftMax2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int rightMin2 = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];

            if(leftMax1 <= rightMin2 && leftMax2 <= rightMin1){
                if(totalLength % 2 == 0)
                    return (Math.max(leftMax1, leftMax2) + Math.min(rightMin1, rightMin2)) / 2.0;
                else return Math.max(leftMax1, leftMax2);
            }
            else if(leftMax1 > rightMin2) right--;
            else left++;
        }

        return 0.0;
    }
}