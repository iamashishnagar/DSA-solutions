class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if(m > n) return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i = 0; i < m; i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        for(int right = m; right < n; right++){
            int left = right - m;
            if(isMatch(s1Count, s2Count)) return true;
            s2Count[s2.charAt(left) - 'a']--;
            s2Count[s2.charAt(right) - 'a']++;
        }
        return isMatch(s1Count, s2Count);
    }

    private boolean isMatch(int[] s1Count, int[] s2Count){
        for(int i = 0; i < 26; i++)
            if(s1Count[i] != s2Count[i])
                return false;
        return true;
    }
}