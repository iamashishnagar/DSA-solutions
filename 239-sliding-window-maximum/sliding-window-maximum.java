class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0 || k > n) return null;
        int[] result = new int[n - k + 1];
        Deque<Integer> indexQ = new ArrayDeque<>();

        for(int right = 0; right < n; right++){
            int left = right - k + 1;
            if(!indexQ.isEmpty() && indexQ.peek() < left)
                indexQ.poll();
            
            while(!indexQ.isEmpty() && nums[indexQ.peekLast()] < nums[right])
                indexQ.pollLast();
            
            indexQ.offerLast(right);

            if(right + 1 >= k) result[left] = nums[indexQ.peek()];
        }

        return result;
    }
}