class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if(n == k) return k;
        if( n < k) return 0;

        int longest = 0, left = 0, maxF = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < n; right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            maxF = Math.max(maxF, map.get(s.charAt(right)));

            if((right - left + 1) - maxF > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }
}