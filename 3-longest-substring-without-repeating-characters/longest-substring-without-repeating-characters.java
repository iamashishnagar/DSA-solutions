class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int longest = 0;
        while(right < s.length()){
            char rChar = s.charAt(right);
            while(set.contains(rChar)){
                longest = Math.max(longest, right - left);
                char lChar = s.charAt(left);
                set.remove(lChar);
                left++;                
            }
            set.add(rChar);
            right++;
        }
        return Math.max(longest, right - left);
    }
}