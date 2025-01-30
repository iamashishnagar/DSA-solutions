class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums) maxHeap.offer(num);

        int i = 0;
        int result = 0;
        while(!maxHeap.isEmpty() && i < k){
            result = maxHeap.poll();
            i++;
        }
        return result;
    }
}