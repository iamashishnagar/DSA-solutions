class Solution {
    public int trap(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax < rightMax)
                result += leftMax - height[left++];
            else 
                result += rightMax - height[right--];
        }

        return result;
    }
}