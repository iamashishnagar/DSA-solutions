class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] edge : times){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new int[] {v, w});
        }

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.offer(new int[] {k, 0});
        Map<Integer, Integer> visited = new HashMap<>();

        while(!minHeap.isEmpty()){
            int[] current = minHeap.poll();
            int node = current[0];
            int time = current[1];

            if(visited.containsKey(node)) continue;
            visited.put(node, time);

            if(graph.containsKey(node)){
                for(int[] neighbor : graph.get(node)){
                    int dest = neighbor[0], travelTime = neighbor[1];
                    if(!visited.containsKey(dest)){
                        minHeap.offer(new int[] {dest, time + travelTime});
                    }
                }
            }
        }

        return visited.size() < n
            ? -1
            : Collections.max(visited.values());
    }
}