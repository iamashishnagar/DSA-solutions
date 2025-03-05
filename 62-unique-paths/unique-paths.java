class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];

        for(int i = m - 1; i >= 0; i--){
            int[] currRow = new int[n];
            currRow[n - 1] = 1;
            for(int j = n - 2; j >= 0; j--){
                currRow[j] = currRow[j + 1] + prevRow[j];
            }
            prevRow = currRow;
        }

        return prevRow[0];
    }
}