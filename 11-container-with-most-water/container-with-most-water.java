class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        if(n < 2) return 0;
        int left = 0, right = n - 1;
        int maxAmount = 0;

        while(left < right){
            int amount = Math.min(height[left], height[right]) * (right - left);
            maxAmount = Math.max(maxAmount, amount);
            if(height[left] < height[right]) left++;
            else right--;
        }

        return maxAmount;
    }
}