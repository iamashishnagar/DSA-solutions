class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;

        Set<String> set = new HashSet<>();

        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                
                char curr = board[i][j];

                if(curr != '.'){
                    String row = curr + " row " + i;
                    String col = curr + " col " + j;
                    String box = curr + " box " + i/3 + "-" + j/3;

                    if(!set.add(row) || !set.add(col) || !set.add(box))
                        return false;
                }

            }
        }

        return true;
        
    }
}