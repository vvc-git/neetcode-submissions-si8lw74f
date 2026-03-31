class Solution {
    public int maxProfit(int[] prices) {
        

        int size = prices.length;
        int left = 0;
        int profit = 0;
        for (int right = 0; right < size; right++) {
            if (prices[right] < prices[left]) {
                left = right;
            }
            profit = Math.max(profit, prices[right] - prices[left]);
        }
        return profit;
    }
}
