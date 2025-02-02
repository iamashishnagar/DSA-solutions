class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                char current = board[i][j];
                if(current != '.'){
                    String row = board[i][j] + " row " + i;
                    String col = board[i][j] + " col " + j;
                    String box = board[i][j] + " box " + i/3 + "-" + j/3;

                    if(!set.add(row) || !set.add(col) || !set.add(box))
                        return false;
                }
            }
        }

        return true;
    }
}