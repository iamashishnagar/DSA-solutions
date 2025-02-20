class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        return Math.max(robHelper(nums, 0, n - 1), robHelper(nums, 1, n));
    }

    private int robHelper(int[] nums, int start, int end){
        int house1 = 0, house2 = 0;
        for(int i = start; i < end; i++){
            int maxSoFar = Math.max(nums[i] + house1, house2);
            house1 = house2;
            house2 = maxSoFar;
        }
        return house2;
    }
}