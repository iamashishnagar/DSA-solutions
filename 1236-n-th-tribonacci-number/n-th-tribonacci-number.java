class Solution {
    Map<Integer, Integer> memo = new HashMap<>();

    public int tribonacci(int n) {
        if(n == 0 || n == 1) return n;
        if(n == 2) return 1;
        if(memo.containsKey(n)) return memo.get(n);

        int result = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
        memo.put(n, result);
        return result;
    }
}