class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0)
            return new ArrayList<>();
        
        String[] digitsToLetters = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };

        List<String> result = new ArrayList<>();
        backtrack(0, digits, digitsToLetters, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int index, String digits, String[] digitsToLetters, StringBuilder current, List<String> result){
        if(index == digits.length()){
            result.add(current.toString());
            return;
        }

        String letters = digitsToLetters[digits.charAt(index) - '0'];

        for(char letter : letters.toCharArray()){
            current.append(letter);
            backtrack(index + 1, digits, digitsToLetters, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}