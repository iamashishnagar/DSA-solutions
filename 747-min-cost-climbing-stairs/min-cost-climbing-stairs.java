class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(dp(n - 1, cost), dp(n - 2, cost));
    }

    private int dp(int i, int[] cost){
        if(i < 0) return 0;
        if(i == 0 || i == 1) return cost[i];
        if(!memo.containsKey(i))
            memo.put(i, cost[i] + Math.min(dp(i - 1, cost), dp(i - 2, cost)));

        return memo.get(i);
    }
}