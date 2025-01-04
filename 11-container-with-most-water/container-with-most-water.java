class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length - 1;

        while(left < right){
            int currHeight = Math.min(height[left], height[right]);
            int width = right - left;
            max = Math.max(max, currHeight * width);

            if(height[left] < height[right]) left++;
            else right--;
        }

        return max;
    }
}