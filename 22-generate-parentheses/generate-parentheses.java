class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        backtracking(result, current, 0, 0, n);
        return result;
    }

    private void backtracking(List<String> result, StringBuilder current, int open, int close, int max){
        if(current.length() == 2 * max)
            result.add(current.toString());
        
        if(open < max){
            backtracking(result, current.append("("), open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        
        if(close < open){
            backtracking(result, current.append(")"), open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}