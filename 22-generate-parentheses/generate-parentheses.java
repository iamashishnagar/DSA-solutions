class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(0, 0, n, result, "");
        return result;
    }

    private void backtrack(int openN, int closeN, int n, List<String> result, String current){
        if(openN == closeN && openN == n){
            result.add(current);
            return;
        }

        if(openN < n)
            backtrack(openN + 1, closeN, n, result, current + "(");

        if(closeN < openN)
            backtrack(openN, closeN + 1, n, result, current + ")");
    }
}