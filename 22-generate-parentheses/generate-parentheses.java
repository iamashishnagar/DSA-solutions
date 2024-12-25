class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0, 0, n, result, new StringBuilder());
        return result;
    }

    private void backtrack(int openN, int closeN, int n, List<String> result, StringBuilder current){
        if(openN == closeN && openN == n){
            result.add(current.toString());
            return;
        }

        if(openN < n){
            backtrack(openN + 1, closeN, n, result, current.append("("));
            current.deleteCharAt(current.length() - 1);
        }

        if(closeN < openN){
            backtrack(openN, closeN + 1, n, result, current.append(")"));
            current.deleteCharAt(current.length() - 1);
        }
    }
}