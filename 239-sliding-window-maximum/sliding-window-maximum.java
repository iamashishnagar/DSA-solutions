class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k > nums.length) return new int[k];
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> indexQ = new ArrayDeque<>();
        for(int right = 0; right < nums.length; right++){
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