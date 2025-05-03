class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid.length == 0) return 0;
        int perimeter = 0;
        int rows = grid.length, cols = grid[0].length;

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(grid[row][col] == 1){
                    perimeter += 4;

                    if(row > 0 && grid[row - 1][col] == 1)
                        perimeter -= 2;
                    if(col > 0 && grid[row][col - 1] == 1)
                        perimeter -= 2;
                }
            }
        }

        return perimeter;
    }
}