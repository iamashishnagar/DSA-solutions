class Solution {
    public List<String> generateParenthesis(int n) {
        if(n == 0) return null;
        List<String> result = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        backtrack(0, 0, n, result, new StringBuilder());
        return result;
    }

    private void backtrack(int open, int close, int n, List<String> result, StringBuilder current){
        if(open == close && open == n){
            result.add(current.toString());
            return;
        }

        if(open < n){
            current.append('(');
            backtrack(open + 1, close, n, result, current);
            current.deleteCharAt(current.length() - 1);
        }

        if(close < open){
            current.append(')');
            backtrack(open, close + 1, n, result, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}