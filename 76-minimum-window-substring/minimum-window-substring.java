class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if(m < n) return "";
        int[] count = new int[128];
        for(int i = 0; i < n; i++)
            count[t.charAt(i)]++;
        
        int need = n, have = 0;
        int left = 0, start = 0, minLength = Integer.MAX_VALUE;

        for(int right = 0; right < m; right++){
            if(count[s.charAt(right)] > 0) have++;
            count[s.charAt(right)]--;

            while(have == need){
                int window = right - left + 1;
                if(window < minLength){
                    minLength = window;
                    start = left;
                }
                if(count[s.charAt(left)] == 0) have--;
                count[s.charAt(left)]++;
                left++;
            }
        }
         return (minLength == Integer.MAX_VALUE) ? "" : s.substring(start, start + minLength);
         
    }
}