class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, String s, List<String> substring, List<List<String>> result){
        if(start == s.length()){
            result.add(new ArrayList<>(substring));
            return;
        }

        for(int end = start; end < s.length(); end++){
            if(isPalindrome(s, start, end)){
                substring.add(s.substring(start, end + 1));
                backtrack(end + 1, s, substring, result);
                substring.remove(substring.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}