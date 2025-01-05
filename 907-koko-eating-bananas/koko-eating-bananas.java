class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = getMaxPile(piles);
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(canEat(piles, h, mid))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    private int getMaxPile(int[] piles){
        int max = 0;
        for(int pile : piles)
            max = Math.max(max, pile);
        return max;
    }

    private boolean canEat(int[] piles, int h, int k){
        int totalHours = 0;
        for(int pile : piles)
            totalHours += Math.ceil((double) pile / k);
        return totalHours <= h;
    }
}