class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int largestArea = 0;
        Deque<Integer> heightStack = new ArrayDeque<>();

        for(int i = 0; i <= n; i++){ //boundary
            int currentHeight = (i == n) ? 0 : heights[i];

            while(!heightStack.isEmpty() && heights[heightStack.peek()] > currentHeight){
                int prevHeight = heights[heightStack.pop()];
                int width = (heightStack.isEmpty()) ? i : i - heightStack.peek() - 1;
                largestArea = Math.max(largestArea, prevHeight * width) ;
            }
            heightStack.push(i);
        }

        return largestArea;
    }
}