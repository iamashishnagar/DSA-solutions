class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n == 0) return null;
        int[] result = new int[n];
        int prefix = 1, suffix = 1;

        for(int i = 0; i < n; i++){
            result[i] = prefix;
            prefix = prefix * nums[i];
        }

        for(int i = n - 1; i >= 0; i--){
            result[i] = result[i] * suffix;
            suffix = suffix * nums[i];
        }

        return result;
    }
}