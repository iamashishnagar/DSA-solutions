class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    countIsland(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void countIsland(int i, int j, char[][] grid){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == '0')
            return;
        
        grid[i][j] = '0';

        for(int[] dir : directions){
            int row = i + dir[0];
            int col = j + dir[1];
            countIsland(row, col, grid);
        }
    }
}