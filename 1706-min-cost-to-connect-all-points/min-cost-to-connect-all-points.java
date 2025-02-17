class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int manDist = Math.abs(points[i][0] - points[j][0])
                            + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[] {i, j, manDist});
            }
        }

        Collections.sort(edges, Comparator.comparingInt(e -> e[2]));
        Union union = new Union(n);
        int minCost = 0, edgeCount = 0;

        for(int[] edge : edges){
            if(union.union(edge[0], edge[1])){
                minCost += edge[2];
                edgeCount++;
                if(edgeCount == n - 1) return minCost;
            }
        }

        return minCost;
    }

    class Union{
        int[] parent;
        int[] rank;

        Union(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        boolean union(int x, int y){
            int rootX = find(x), rootY = find(y);
            if(rootX == rootY) return false;

            if(rank[rootX] < rank[rootY])
                parent[rootX] = rootY;
            else if(rank[rootX] > rank[rootY])
                parent[rootY] = rootX;
            else{
                parent[rootX] = rootY;
                rank[rootY]++;
            }

            return true;
        }

        int find(int x){
            if(parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }
    }
}