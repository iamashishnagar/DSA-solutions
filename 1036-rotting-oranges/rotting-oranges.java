class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2)
                    queue.add(new int[] {i, j});
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }

        if(fresh == 0) return 0;
        int minutes = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rotted = false;

            while(size > 0){
                int[] cell = queue.poll();
                for(int[] dir : directions){
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];

                    if(row >= 0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1){
                        grid[row][col] = 2;
                        queue.add(new int[] {row, col});
                        rotted = true;
                        fresh--;
                    }
                }
                size--;
            }
            if(rotted) minutes++;
        }

        return fresh == 0 ? minutes : -1;

    }
}