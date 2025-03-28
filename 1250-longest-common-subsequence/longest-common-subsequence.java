class Solution {
    private int[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        this.dp = new int[text1.length()][text2.length()];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return lcsHelper(0, 0, text1, text2);
    }

    private int lcsHelper(int i, int j, String text1, String text2){
        if(i == text1.length() || j == text2.length())
            return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(text1.charAt(i) == text2.charAt(j))
            dp[i][j] = 1 + lcsHelper(i + 1, j + 1, text1, text2);
        else
            dp[i][j] = Math.max(lcsHelper(i, j + 1, text1, text2), lcsHelper(i + 1, j, text1, text2));
        
        return dp[i][j];
    }
}