class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int left = 1, right = maxPile;
        int min = Integer.MAX_VALUE;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canEatAll(piles, h, mid)){
                min = Math.min(min, mid);
                right = mid - 1;
            }
            else left = mid + 1;
        }

        return min;
    }

    private boolean canEatAll(int[] piles, int h, int k){
        int totalHours = 0;
        for(int pile : piles)
            totalHours += Math.ceil((double) pile / k);
        return totalHours <= h;
    }
}