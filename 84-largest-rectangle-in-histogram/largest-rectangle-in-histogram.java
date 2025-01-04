class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int largest = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= n; i++){
            int curr = (i == n) ? 0 : heights[i];

            while(!stack.isEmpty() && curr < heights[stack.peek()]){
                int pre = heights[stack.pop()];
                int width = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                largest = Math.max(largest, pre * width);
            }
            stack.push(i);
        }
        return largest;
    }
}