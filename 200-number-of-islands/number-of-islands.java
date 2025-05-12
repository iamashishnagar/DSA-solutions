class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0')
            return;
        
        grid[i][j] = '0';

        for(int[] dir : directions){
            int row = i + dir[0];
            int col = j + dir[1];
            dfs(grid, row, col);
        }
    }
}