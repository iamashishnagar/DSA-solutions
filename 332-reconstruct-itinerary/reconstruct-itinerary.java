class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        //graph with PriorityQueue in smallest destination order
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }
        //dfs path from source
        List<String> path = new LinkedList<>();
        dfs("JFK", path, graph);
        //return reversed path
        return path;
    }

    private void dfs(String source, List<String> path, Map<String, PriorityQueue<String>> graph){
        PriorityQueue<String> destinations = graph.get(source);
        while(destinations != null && !destinations.isEmpty())
            dfs(destinations.poll(), path, graph);
        
        path.addFirst(source);
    }
}