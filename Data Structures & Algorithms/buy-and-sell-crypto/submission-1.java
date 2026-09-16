class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int curr = prices.length - 1;
        int ptr = curr - 1;

        while (ptr >= 0 && curr >= 0) {
            if (prices[ptr] < prices[curr]) {
                profit = Math.max(profit, prices[curr] - prices[ptr]);
                ptr--;
            } else {
                curr = ptr;
                ptr--;
            }
        }
        return profit;
    }
}
