class Solution {
    private int n, m;
    private int[] nums, multipliers;
    private int[][] memo;

    public int maximumScore(int[] nums, int[] multipliers) {
        this.n = nums.length;
        this.m = multipliers.length;
        this.nums = nums;
        this.multipliers = multipliers;

        this.memo = new int[m][m];

        return dp(0, 0);
    }

    private int dp(int i, int left){
        if(i == m) return 0;
        int right = n - 1 - (i - left);
        int multi = multipliers[i];

        if(memo[i][left] == 0)
            memo[i][left] = Math.max(multi * nums[left] + dp(i + 1, left + 1),
                                    multi * nums[right] + dp(i + 1, left));
        
        return memo[i][left];
    }
}