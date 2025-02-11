class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        if(board.length == 0) return;
        int rows = board.length, cols = board[0].length;

        for(int r = 0; r < rows; r++){
            if(board[r][0] == 'O') dfs(r, 0, board);
            if(board[r][cols - 1] == 'O') dfs(r, cols - 1, board);
        }

        for(int c = 0; c < cols; c++){
            if(board[0][c] == 'O') dfs(0, c, board);
            if(board[rows - 1][c] == 'O') dfs(rows - 1, c, board);
        }

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int i, int j, char[][] board){
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O')
            return;
        
        board[i][j] = '#';
        for(int[] dir : directions){
            dfs(i + dir[0], j + dir[1], board);
        }
    }
}