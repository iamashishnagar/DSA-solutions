class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char task : tasks)
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freqMap.values());

        int maxFreq = maxHeap.poll();
        int countMaxFreqTasks = 1;

        while(!maxHeap.isEmpty() && maxHeap.peek() == maxFreq){
            maxHeap.poll();
            countMaxFreqTasks++;
        }

        int leastCycles = (maxFreq - 1) * (n + 1) + countMaxFreqTasks;

        return Math.max(leastCycles, tasks.length);
    }
}