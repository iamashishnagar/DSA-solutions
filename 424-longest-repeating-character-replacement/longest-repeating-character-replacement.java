class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int longest = 0, maxFreq = 0;

        while(right < s.length()){
            char rChar = s.charAt(right);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(rChar));

            if((right - left + 1) - maxFreq > k){
                char lChar = s.charAt(left);
                map.put(lChar, map.getOrDefault(lChar, 0) - 1);
                left++;
            }

            longest = Math.max(longest, right - left + 1);
            right++;
        } 

        return longest;       
    }
}