class Solution {
    int count = 0;
    Set<String> visited = new HashSet<>();
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited.contains(i + "," + j)){
                    count++;
                    countIslands(grid, i, j);
                }
            }
        }
        return count;
    }

    private void countIslands(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0' || visited.contains(row + "," + col))
            return;

        visited.add(row + "," + col);

        for(int[] dir : directions)
            countIslands(grid, row + dir[0], col + dir[1]);
    }
}