class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length == 0) return 0;
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        while(left < right){
            int mid = left + (right - left) / 2;
            if(canEatAll(piles, h, mid)){
                right = mid;
            }
            else left = mid + 1;
        }
        return left;
    }

    private boolean canEatAll(int[] piles, int h, int mid){
        int total = 0;
        for(int pile : piles)
            total += Math.ceil((double) pile / mid);
        return total <= h;
    }
}