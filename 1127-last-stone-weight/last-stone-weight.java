class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int stone : stones)
            maxHeap.add(stone);

        while(maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if(first - second != 0)
                maxHeap.add(first - second);
        }

        maxHeap.add(0); //if heap is empty
        return maxHeap.poll();
    }
}