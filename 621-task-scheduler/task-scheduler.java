class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char task : tasks)
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freqMap.values());
        
        int lastMax = 0;
        if(!maxHeap.isEmpty())
            lastMax = maxHeap.poll();
        int maxFreqCount = 1;
        while(!maxHeap.isEmpty() && maxHeap.poll() == lastMax)
            maxFreqCount++;

        int leastCycle = ((lastMax - 1) * (n + 1)) + maxFreqCount;

        return Math.max(leastCycle, tasks.length);
    }
}