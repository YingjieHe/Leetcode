public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++) {
            int min = -1;
            for(int coin : coins) {
                if(i >= coin && dp[i - coin] != -1) {
                    int temp = dp[i - coin] + 1;
                    if(min < 0) min = temp;
                    else min = Math.min(min, temp);
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }
}