class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        if(grid.length == 0) return maxArea;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int i, int j, int[][] grid){
        if(i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0)
            return 0;
        
        grid[i][j] = 0;
        int area = 1;

        for(int[] dir : directions){
            int row = i + dir[0];
            int col = j + dir[1];

            area += dfs(row, col, grid);
        }
        
        return area;
    }
}