class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int total = 0;
        if(grid.length == 0) return total;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    total++;
                    dfs(i, j, grid);
                }
            }
        }

        return total;
    }

    private void dfs(int i, int j, char[][] grid){
        grid[i][j] = '0';

        for(int[] dir : directions){
            int row = i + dir[0];
            int col = j + dir[1];

            if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == '1')
                dfs(row, col, grid);
        }
    }
}