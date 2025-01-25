class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0)
            return new ArrayList<>();
        String[] digitToLetters = {
            "", //0
            "", //1
            "abc", //2
            "def", //3
            "ghi", //4
            "jkl", //5
            "mno", //6
            "pqrs", //7
            "tuv", //8
            "wxyz" //9
        };

        List<String> result = new ArrayList<>();
        backtrack(0, digits, digitToLetters, new StringBuilder(), result);
        return result;
    }

    private void backtrack(int index, String digits, String[] digitToLetters, StringBuilder current, List<String> result){
        if(index == digits.length()){
            result.add(current.toString());
            return;
        }

        String letters = digitToLetters[digits.charAt(index) - '0'];

        for(char letter : letters.toCharArray()){
            current.append(letter);
            backtrack(index + 1, digits, digitToLetters, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}