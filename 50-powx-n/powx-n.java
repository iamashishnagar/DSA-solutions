class Solution {
    public double myPow(double x, int n) {
        if(x == (double) 0) return 0;
        if(n == 0) return 1;

        double result = helper(x, Math.abs(n));
        return n >= 0 ? result : 1 / result;
    }

    private double helper(double x, int n){
        if(n == 0) return 1;

        double half = helper(x, n / 2);
        double result = half * half;
        return n % 2 == 0 ? result : x * result;
    }
}