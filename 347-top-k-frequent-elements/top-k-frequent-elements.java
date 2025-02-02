class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums)
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));
        for(int key : freqMap.keySet()){
            maxHeap.offer(key);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        int[] result = new int[k];
        for(int i = 0; i < k && !maxHeap.isEmpty(); i++)
            result[i] = maxHeap.poll();

        return result;
    }
}