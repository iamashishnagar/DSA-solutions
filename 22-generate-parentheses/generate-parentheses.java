class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int n){
        if(current.length() == 2 * n){
            result.add(current.toString());
            return;
        }

        if(open < n){
            backtrack(result, current.append('('), open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        }

        if(close < open){
            backtrack(result, current.append(')'), open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}