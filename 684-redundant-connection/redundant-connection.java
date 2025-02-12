class Solution {
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];

        for(int i = 1; i <= n; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(int[] edge : edges)
            if(!union(edge[0], edge[1]))
                return new int[] {edge[0], edge[1]};

        return new int[] {edges[n][0], edges[n][1]};
    }

    private boolean union(int x, int y){
        int rootX = find(x), rootY = find(y);
        if(rootX ==  rootY) return false;

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

    private int find(int x){
        if(parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }
}