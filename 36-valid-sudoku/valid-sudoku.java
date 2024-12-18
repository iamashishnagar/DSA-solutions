class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                char current = board[i][j];

                if(current != '.'){
                    String row = current + " row " + i;
                    String col = current + " col " + j;
                    String box = current + " box "+ i/3 + "-" + j/3;

                    if(!set.add(row) || !set.add(col) || !set.add(box))
                        return false;
                }
            }
        }

        return true;
        
    }
}