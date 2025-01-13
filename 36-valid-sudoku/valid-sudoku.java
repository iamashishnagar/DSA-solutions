class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                char digit = board[i][j];
                if(digit != '.'){
                    String row = digit + " in row " + i;
                    String col = digit + " in col " + j;
                    String box = digit + " in box " + i / 3 + "-" + j / 3;

                    if(!set.add(row) || !set.add(col) || !set.add(box))
                        return false;
                }
            }
        }
        return true;
    }
}