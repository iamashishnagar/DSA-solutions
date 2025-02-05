class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int largest = 0;

        for(int i = 0; i <= n; i++){
            int currHeight = (i == n) ? 0 : heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > currHeight){
                int prevHeight = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                largest = Math.max(largest, prevHeight * width);
            }
            stack.push(i);
        }
        return largest;
    }
}