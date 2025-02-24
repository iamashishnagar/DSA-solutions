class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int prev2 = 1; //for empty input - only one way
        int prev1 = 1; //for valid first char - only one way

        for(int i = 1; i < s.length(); i++){
            int current = 0;
            if(s.charAt(i) != '0') //valid case
                current += prev1;
            
            int doubleDigits = Integer.parseInt(s.substring(i - 1, i + 1));
            if(doubleDigits >= 10 && doubleDigits <= 26) //valid case
                current += prev2;

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}