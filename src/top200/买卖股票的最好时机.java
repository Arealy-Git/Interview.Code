package top200;

public class 买卖股票的最好时机 {

    public int maxProfit(int[] prices) {
        int min_num = prices[0];
        int max_profit = 0;
        for (int i = 0; i < prices.length; i++) {
            min_num = Math.min(min_num, prices[i]);
            max_profit = Math.max(max_profit, prices[i] - min_num);
        }
        return max_profit;
    }

}
