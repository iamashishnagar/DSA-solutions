class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length() )
            return "";

        int[] tMap = new int[128];
        for(int i = 0; i < t.length(); i++){
            tMap[t.charAt(i)]++;
        }

        int left = 0, right = 0;
        int requiredCount = t.length();
        int startIndex = 0;
        int minLength = Integer.MAX_VALUE;

        while(right < s.length()){
            if(tMap[s.charAt(right)] > 0)
                requiredCount--;
            tMap[s.charAt(right)]--;
            right++;

            while(requiredCount == 0){
                int length = right - left;
                if(length < minLength){
                    minLength = length;
                    startIndex = left;
                }

                tMap[s.charAt(left)]++;
                if(tMap[s.charAt(left)] > 0){
                    requiredCount++;
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}