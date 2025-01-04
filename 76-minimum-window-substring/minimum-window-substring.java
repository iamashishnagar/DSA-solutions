class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m < n) return "";
        int[] tMap = new int[128];
        for(char c : t.toCharArray())
            tMap[c]++;

        int need = n;
        int have = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        int left = 0;

        for(int right = 0; right < m; right++){
            if(tMap[s.charAt(right)] > 0) have++;
            tMap[s.charAt(right)]--;

            while(have == need){
                int length = right - left + 1;
                if(length < min){
                    min = length;
                    start = left;
                }
                tMap[s.charAt(left)]++;
                if(tMap[s.charAt(left)] > 0) have--; // Only decrement if it was part of t
                left++;
            }
        }

        return (min == Integer.MAX_VALUE) ? "" : s.substring(start, start + min);      
    }
}