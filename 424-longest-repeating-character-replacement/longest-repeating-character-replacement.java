class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxF = 0;

        for(int right = 0; right < s.length(); right++){
            char rChar = s.charAt(right);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);
            maxF = Math.max(maxF, map.get(rChar));

            if((right - left + 1) - maxF > k){
                char lChar = s.charAt(left);
                map.put(lChar, map.getOrDefault(lChar, 0) - 1);
                left++;
            }
            
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}