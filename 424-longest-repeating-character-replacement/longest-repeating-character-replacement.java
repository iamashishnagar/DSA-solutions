class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        if(s.length() == 0) return longest;
        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0, right = 0;
        int maxFreq = 0;
        while(right < s.length()){
            char rChar = s.charAt(right);
            freqMap.put(rChar, freqMap.getOrDefault(rChar, 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(rChar));
            int window = right - left + 1;
            if(window - maxFreq > k){
                char lChar = s.charAt(left);
                freqMap.put(lChar, freqMap.get(lChar) - 1);
                left++;
            }
            longest = Math.max(longest, right - left + 1);
            right++;            
        }
        return longest;
    }
}