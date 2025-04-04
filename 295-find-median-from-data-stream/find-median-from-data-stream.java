class MedianFinder {
    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        if(!minHeap.isEmpty() && (maxHeap.peek() > minHeap.peek()))
            minHeap.offer(maxHeap.poll());

        if(minHeap.size() > maxHeap.size())
            maxHeap.offer(minHeap.poll());
        else if(maxHeap.size() > minHeap.size() + 1)
            minHeap.offer(maxHeap.poll());
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */