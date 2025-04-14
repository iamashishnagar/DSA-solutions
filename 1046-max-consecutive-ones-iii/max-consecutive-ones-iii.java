class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, maxZeros = 0, maxLength = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0) maxZeros++;

            while(maxZeros > k){
                if(nums[left] == 0) maxZeros--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}