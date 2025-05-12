class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int buyingPrice = Integer.MAX_VALUE;

        for(int price : prices){
            if(price < buyingPrice)
                buyingPrice = price;
            else if(price > buyingPrice){
                max = Math.max(max, price - buyingPrice);
            }
        }

        return max;
    }
}