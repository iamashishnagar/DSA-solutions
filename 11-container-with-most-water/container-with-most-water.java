class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        if(height.length == 0) return max;
        int left = 0, right = height.length - 1;
        while(left < right){
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]) left++;
            else right--;
        }

        return max;
    }
}