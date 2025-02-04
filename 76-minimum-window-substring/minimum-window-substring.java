class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if(n > m) return "";

        int[] count = new int[128];
        for(char c : t.toCharArray())
            count[c]++;

        int minLength = Integer.MAX_VALUE;
        int left = 0, right = 0, start = 0;
        int need = n, have = 0;

        for(; right < m; right++){
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

        return (minLength == Integer.MAX_VALUE)
                ? ""
                : s.substring(start, start + minLength);
    }
}