class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1) return -1;
        if(n == 1) return 1;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int step = 1;
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                int[] values = queue.poll();
                for(int[] dir : directions){
                    int row = values[0] + dir[0];
                    int col = values[1] + dir[1];

                    if(row < 0 || col < 0 || row >= n || col >= n || grid[row][col] == 1 || visited[row][col])
                        continue;
                    if(row == n - 1 && col == n - 1)
                        return step + 1;

                    queue.offer(new int[]{row, col});
                    visited[row][col] = true;
                }
                size--;
            }
            step++;
        }

        return -1;
    }
}