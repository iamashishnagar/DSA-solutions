class Solution {
    public int trap(int[] height) {
        int total = 0;
        if(height.length == 0) return total;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while(left <= right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(height[left] < height[right]){
                total += leftMax - height[left];
                left++;
            }
            else{
                total += rightMax - height[right];
                right--;
            }
        }
        return total;
    }
}