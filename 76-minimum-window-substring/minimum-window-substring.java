class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if(m < n) return "";

        int[] count = new int[128]; //ASCII
        for(char c : t.toCharArray())
            count[c]--;
        
        int min = Integer.MAX_VALUE, start = 0, left = 0;

        for(int right = 0; right < m; right++){
            if(count[s.charAt(right)] < 0) n--;
            count[s.charAt(right)]++;

            while(n == 0){
                int window = right - left + 1;
                if(window < min){
                    min = window;
                    start = left;
                }

                count[s.charAt(left)]--;
                if(count[s.charAt(left)] < 0) n++;
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
        
    }
}