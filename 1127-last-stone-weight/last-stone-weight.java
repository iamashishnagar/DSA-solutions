class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones)
            maxHeap.offer(stone);
        
        while(!maxHeap.isEmpty()){
            if(maxHeap.size() == 1)
                return maxHeap.peek();
            
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if(first > second) maxHeap.offer(first - second);
        }
        return 0;
    }
}