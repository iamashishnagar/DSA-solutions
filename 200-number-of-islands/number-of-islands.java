class Solution {
    private int m, n;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if(m == 0) return 0;
        int result = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    result++;
                    bfs(i, j, grid);
                }
            }
        }

        return result;
    }

    private void bfs(int i, int j, char[][] grid){
        if(i < 0 || i == m || j < 0 || j == n || grid[i][j] == '0')
            return;
        
        if(grid[i][j] == '1')
            grid[i][j] = '0';
        
        for(int[] dir : directions){
            bfs(i + dir[0], j + dir[1], grid);
        }
    }
}