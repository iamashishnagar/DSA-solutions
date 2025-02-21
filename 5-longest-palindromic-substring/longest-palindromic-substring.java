class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        for(int i = 0; i < s.length(); i++){
            int lengthOdd = expandAroundCenter(s, i, i);
            int lengthEven = expandAroundCenter(s, i, i + 1);
            int maxLength = Math.max(lengthOdd, lengthEven);

            if(maxLength > right - left){
                left = i - (maxLength - 1) / 2;
                right = i + maxLength / 2;
            }
        }

        return s.substring(left, right + 1);
    }

    private int expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}