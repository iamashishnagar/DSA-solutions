class Solution {
    public int trap(int[] height) {
        int max = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.length - 1;

        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            max += (leftMax < rightMax)
                ? (leftMax - height[left++])
                : (rightMax - height[right--]);
        }   

        return max;     
    }
}