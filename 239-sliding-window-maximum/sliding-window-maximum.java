class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0 || nums.length < k)
            return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> indexQ = new LinkedList<>();

        for(int right = 0; right < n; right++){
            int left = right - k + 1; // k = right - left + 1
            if(!indexQ.isEmpty() && indexQ.getFirst() < left)
                indexQ.removeFirst();

            while(!indexQ.isEmpty() && nums[indexQ.getLast()] < nums[right])
                indexQ.removeLast();

            indexQ.addLast(right);

            if(right + 1 >= k)
                result[left] = nums[indexQ.getFirst()];
        }

        return result;        
    }
}