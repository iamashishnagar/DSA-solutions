class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int largest = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i <= n; i++){
            int curr = (i == n) ? 0 : heights[i];

            while(!stack.isEmpty() && curr < heights[stack.peekLast()]){
                int pre = heights[stack.removeLast()];
                int width = (stack.isEmpty()) ? i : i - stack.peekLast() - 1;
                largest = Math.max(largest, pre * width);
            }
            stack.addLast(i);
        }
        return largest;
    }
}