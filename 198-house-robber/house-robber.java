class Solution {
    public int rob(int[] nums) {
        int house1 = 0;
        int house2 = 0;
        for(int i = 0; i < nums.length; i++){
            int current = Math.max(nums[i] + house1, house2);
            house1 = house2;
            house2 = current;
        }
        return house2;
    }
}