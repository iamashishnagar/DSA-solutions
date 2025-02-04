class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        if(piles.length == h) return right;
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

    private boolean canEatAll(int[] piles, int h, int mid){
        int totalHours = 0;
        for(int pile : piles)
            totalHours += Math.ceil((double) pile / mid);
        return totalHours <= h;
    }
}