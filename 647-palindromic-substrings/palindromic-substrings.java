class Solution {
    public int countSubstrings(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            result += expandAroundCenter(s, i, i); //odd
            result += expandAroundCenter(s, i, i + 1); //even
        }
        return result;
    }

    private int expandAroundCenter(String s, int left, int right){
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}