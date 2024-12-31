class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for(int i = 0; i <= n; i++){
            int curr = (i == n) ? 0 : heights[i];
            
            while(!stack.isEmpty() && curr < heights[stack.peek()]){
                int pre = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                max = Math.max(max, pre * width);
            }
            stack.push(i);
        }  

        return max;      
    }
}