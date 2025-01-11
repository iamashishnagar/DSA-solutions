class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();
        if(piles.length == h) 
            return maxPile;
        int minK = Integer.MAX_VALUE;
        
        int left = 1, right = maxPile;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canEatAll(piles, h, mid)){
                minK = Math.min(minK, mid);
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return minK;
             
    }

    private boolean canEatAll(int[] piles, int h, int mid){
        int totalHours = 0;
        for(int pile : piles){
            totalHours += Math.ceil((double) pile / mid);
        }

        return totalHours <= h;
    }
}