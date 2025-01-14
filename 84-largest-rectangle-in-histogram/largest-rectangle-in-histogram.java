class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int largestArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i <= n; i++){
            int currHeight = (i == n) ? 0 : heights[i];
            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){
                int prevHeight = heights[stack.pop()];
                int totalWidth = stack.isEmpty() ? i : i - stack.peek() - 1;
                largestArea = Math.max(largestArea, prevHeight * totalWidth);
            }
            stack.push(i);
        }

        return largestArea;
    }
}