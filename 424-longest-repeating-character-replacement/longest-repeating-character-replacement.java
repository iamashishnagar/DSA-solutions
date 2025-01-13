class Solution {
    public int characterReplacement(String s, int k) {
        if(k == s.length()) return k;
        int longest = 0;
        int left = 0, right = 0;
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < s.length()){
            char rChar = s.charAt(right);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(rChar));
            
            int window = right - left + 1;
            if(window - maxFreq > k){                
                char lChar = s.charAt(left);
                map.put(lChar, map.get(lChar) - 1);
                left++;
            }
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest;
    }
}