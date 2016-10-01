public class Solution {
    public int maxProfit(int[] prices) {
        /*
        buy[i]  = max(rest[i-1]-price, buy[i-1]) 
        sell[i] = max(buy[i-1]+price, sell[i-1])
        rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
        
        But rest[i] = sell[i-1]
        
        Thus buy[i] = max(sell[i-2]-price, buy[i-1])
            sell[i] = max(buy[i-1]+price, sell[i-1])
        */
        if(prices == null || prices.length == 0) return 0;
        int prev_sell = 0, sell = 0, prev_buy, buy = Integer.MIN_VALUE;
        for(int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}