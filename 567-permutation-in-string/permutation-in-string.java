class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for(int i = 0; i < s1.length(); i++){
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        int left = 0, right = s1.length() - 1;
        while(right < s2.length() - 1){
            if(isMatch(s1Count, s2Count)) return true;
            s2Count[s2.charAt(left++) - 'a']--;
            s2Count[s2.charAt(++right) - 'a']++;
        }
        return isMatch(s1Count, s2Count);
    }

    private boolean isMatch(int[] s1Count, int[] s2Count){
        for(int i = 0; i < 26; i++){
            if(s1Count[i] != s2Count[i])
                return false;
        }
        return true;
    }
}