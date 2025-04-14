class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 0) return 0;
        int max = 0;
        int currentMax = 0;

        for(int num : nums){
            if(num == 1){
                currentMax++;
                max = Math.max(max, currentMax);
            }
            else{
                currentMax = 0;
            }
        }

        return max;
    }
}