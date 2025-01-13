class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int longest = 0;
        while(right < s.length()){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest;
    }
}