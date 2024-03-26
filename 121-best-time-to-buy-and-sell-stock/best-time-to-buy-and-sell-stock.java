class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE, maxProfit = 0;

        for (int price: prices) {
            if (buyPrice < price) {
                int profit = price - buyPrice;
                maxProfit = Math.max(maxProfit, profit); 
            } else {
                buyPrice = price;
            }
        }

        return maxProfit;
    }
}