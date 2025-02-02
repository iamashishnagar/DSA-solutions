class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) return new int[0];
        int[] result = new int[nums.length];
        int prefix = 1;
        int postfix = 1;
        for(int i = 0; i < nums.length; i++){
            result[i] = prefix;
            prefix = prefix * nums[i];
        }
        for(int i = nums.length - 1; i >= 0; i--){
            result[i] = result[i] * postfix;
            postfix = postfix * nums[i];
        }
        return result;
    }
}