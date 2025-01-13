class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int result = 0;
        int leftMax = 0, rightMax = 0;
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            result += (leftMax < rightMax)
                        ? leftMax - height[left++]
                        : rightMax - height[right--];
        }

        return result;
    }
}