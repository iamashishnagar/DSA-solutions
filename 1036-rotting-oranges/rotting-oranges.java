class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
                else if(grid[i][j] == 1)
                    freshCount++;
            }
        }

        if(freshCount == 0) return 0;
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rotted = false;

            while(size > 0){
                int[] cell = queue.poll();
                for(int[] dir : directions){
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];

                    if(row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1){
                        grid[row][col] = 2;
                        queue.offer(new int[]{row, col});
                        freshCount--;
                        rotted = true;
                    }
                }
                size--;
            }
            if(rotted) minutes++;
        }

        return (freshCount == 0) ? minutes : -1;
    }
}