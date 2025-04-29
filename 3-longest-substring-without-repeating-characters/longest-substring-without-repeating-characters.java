class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int longest = 0;
        int left = 0, right = 0;

        for(; right < s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }

            set.add(s.charAt(right));
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}