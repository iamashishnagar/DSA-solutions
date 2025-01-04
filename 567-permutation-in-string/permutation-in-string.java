class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if(m > n) return false;

        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for(int i = 0; i < m; i++){
            s1Arr[s1.charAt(i) - 'a']++;
            s2Arr[s2.charAt(i) - 'a']++;
        }

        int left = 0, right = m - 1;

        for(int i = 0; i < n - m; i++){
            if (match(s1Arr, s2Arr)) return true;

            s2Arr[s2.charAt(i) - 'a']--;
            s2Arr[s2.charAt(i + m) - 'a']++;

        }
        return match(s1Arr, s2Arr);
    }

    private boolean match(int[] s1Arr, int[] s2Arr){
        for(int i = 0; i < 26; i++){
            if(s1Arr[i] != s2Arr[i])
                return false;
        }

        return true;
    }
}