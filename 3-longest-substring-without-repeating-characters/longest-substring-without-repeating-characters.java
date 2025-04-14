class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Set<Character> set = new HashSet<>();
        int left = 0, longest = 0;

        for(int right = 0; right < s.length(); right++){
            while(set.contains(s.charAt(right)))
                set.remove(s.charAt(left++));
            
            set.add(s.charAt(right));
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}