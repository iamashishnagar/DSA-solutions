class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0) return 0;
        Set<Character> set = new HashSet<>();
        int longest = 0, left = 0, right = 0;

        for(right = 0; right < n; right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            longest = Math.max(longest, right - left + 1);
        }

        return longest;        
    }
}