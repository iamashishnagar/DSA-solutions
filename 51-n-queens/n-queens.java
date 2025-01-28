class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDia = new HashSet<>();
        Set<Integer> negDia = new HashSet<>();

        char[][] board = new char[n][n];
        for(char[] row : board)
            Arrays.fill(row, '.');
        
        backtrack(0, n, board, cols, posDia, negDia, result);

        return result;
    }

    private void backtrack(int row, int n, char[][] board, Set<Integer> cols, Set<Integer> posDia, Set<Integer> negDia, List<List<String>> result){
        if(row == n){
            List<String> tempList = new ArrayList<>();
            for(char[] rowStr : board)
                tempList.add(new String(rowStr));
            result.add(tempList);
            return;
        }
        
        for(int col = 0; col < n; col++){
            if(cols.contains(col) || posDia.contains(row + col) || negDia.contains(row - col))
                continue;
            
            board[row][col] = 'Q';
            cols.add(col);
            posDia.add(row + col);
            negDia.add(row - col);

            backtrack(row + 1, n, board, cols, posDia, negDia, result);

            board[row][col] = '.';
            cols.remove(col);
            posDia.remove(row + col);
            negDia.remove(row - col);
        }
    }
}