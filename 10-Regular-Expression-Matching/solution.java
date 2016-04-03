public class Solution {
    public boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        dp[0][0] = true;
        for(int i = 0; i <= sl; i++){
            for(int j = 1; j <= pl; j++){
                char c = p.charAt(j - 1);
                if(c != '*'){
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (c == '.' || c == s.charAt(i - 1));
                }
                else{
                    dp[i][j] = (j > 1 && dp[i][j - 2]) || (i > 0 && dp[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)));
                }
            }
        }
        return dp[sl][pl];
    }
}