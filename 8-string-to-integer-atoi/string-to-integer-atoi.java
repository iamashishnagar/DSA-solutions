class Solution {

    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        int sign  = 1;
        int i = 0;
        long result = 0;

        if(s.charAt(i) == '-'){
            sign = -1;
            i++;
        }
        else if(s.charAt(i) == '+') i++;

        for(; i < s.length(); i++){
            char c = s.charAt(i);
            if(c < '0' || c > '9') break;

            result = result * 10 + (c - '0');

            if(result * sign > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(result * sign < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) result * sign;
    }
}