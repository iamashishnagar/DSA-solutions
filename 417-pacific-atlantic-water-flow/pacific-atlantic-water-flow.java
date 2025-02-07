class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacificVisited = new boolean[rows][cols];
        boolean[][] atlanticVisited = new boolean[rows][cols];

        for(int row = 0; row < rows; row++){
            dfs(row, 0, pacificVisited, heights);
            dfs(row, cols - 1, atlanticVisited, heights);
        }
        for(int col = 0; col < cols; col++){
            dfs(0, col, pacificVisited, heights);
            dfs(rows - 1, col, atlanticVisited, heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pacificVisited[i][j] && atlanticVisited[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }

        return result;
    }

    private void dfs(int i, int j, boolean[][] visited, int[][] heights){
        visited[i][j] = true;

        for(int[] dir : directions){
            int row = i + dir[0];
            int col = j + dir[1];

            if(row >= 0 && col >= 0 && row < heights.length && col < heights[0].length && !visited[row][col] && heights[row][col] >= heights[i][j])
                dfs(row, col, visited, heights);
        }
    }
}