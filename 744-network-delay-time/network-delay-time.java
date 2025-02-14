class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //build graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge : times){
            int u = edge[0], v = edge[1], w = edge[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[] {v, w});
        }
        //minHeap to process shortest path first
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[] {k, 0});
        //visited map keeping distance
        Map<Integer, Integer> visited = new HashMap<>();
        //dijkstra algo
        while(!minHeap.isEmpty()){
            int[] current = minHeap.poll();
            int node = current[0], time = current[1];
            if(visited.containsKey(node)) continue;
            visited.put(node, time);

            if(graph.containsKey(node)){
                for(int[] neighbor : graph.get(node)){
                    int nextNode = neighbor[0], nextTime = neighbor[1];
                    if(!visited.containsKey(nextNode)){
                        minHeap.offer(new int[] {nextNode, time + nextTime});
                    }
                }
            }
        }

        return (visited.size() < n)
            ? -1
            : Collections.max(visited.values());
    }
}