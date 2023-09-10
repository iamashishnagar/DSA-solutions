class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        if(length == 1) return nums[0];
        if(length == 2) return Math.min(nums[0], nums[1]);
        if(nums[0] < nums[length - 1]) return nums[0];

        int left = 0, right = length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if(nums[mid - 1] > nums[mid]) return nums[mid];
            if(nums[left] < nums[mid]) left = mid + 1;
            else right = mid - 1;
        }
        return 0;
    }
}