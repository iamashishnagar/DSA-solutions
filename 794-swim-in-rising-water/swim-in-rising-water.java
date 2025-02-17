class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Set<String> visited = new HashSet<>();
        minHeap.offer(new int[] {grid[0][0], 0, 0});
        visited.add("0, 0");
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!minHeap.isEmpty()){
            int[] current = minHeap.poll();
            int time = current[0], r = current[1], c = current[2];
            if(r == n - 1 && c == n - 1) return time;

            for(int[] dir : directions){
                int row = r + dir[0], col = c + dir[1];
                if(row >= 0 && col >= 0 && row < n && col < n){
                    if(!visited.contains(row + "," + col)){
                        int nextTime = Math.max(time, grid[row][col]);
                        minHeap.offer(new int[] {nextTime, row, col});
                        visited.add(row + "," + col);
                    }
                }
            }
        }

        return -1;
    }
}