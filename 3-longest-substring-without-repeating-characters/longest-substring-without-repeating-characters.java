class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int longestLength = 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;

        while(right < s.length()){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            
            int window = right - left + 1;
            longestLength = Math.max(longestLength, window);
            right++;
        }

        return longestLength;
    }
}