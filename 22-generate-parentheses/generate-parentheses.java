class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, "", 0, 0, n);
        return result;
    }

    private void backtracking(List<String> result, String current, int open, int close, int max){
        if(current.length() == 2 * max)
            result.add(current);
        
        if(open < max)
            backtracking(result, current + "(", open + 1, close, max);
        
        if(close < open)
            backtracking(result, current + ")", open, close + 1, max);
    }
}