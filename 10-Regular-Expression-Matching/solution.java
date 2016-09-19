public class Solution {
    public boolean isMatch(String s, String p) {
        /**
         * f[i][j]: if s[0..i-1] matches p[0..j-1]
         * if p[j - 1] != '*'
         *      f[i][j] = f[i - 1][j - 1] && s[i - 1] == p[j - 1]
         * if p[j - 1] == '*', denote p[j - 2] with x
         *      f[i][j] is true iff any of the following is true
         *      1) "x*" repeats 0 time and matches empty: f[i][j - 2]
         *      2) "x*" repeats >= 1 times and matches "x*x": s[i - 1] == x && f[i - 1][j]
         * '.' matches any single character
         */
         if(s == null || p == null) return false;
         int m = s.length(), n = p.length();
         boolean[][] dp = new boolean[m + 1][n + 1];
         dp[0][0] = true;
         for(int i = 1; i <= m; i++) dp[i][0] = false;
         // p[0.., j - 3, j - 2, j - 1] matches empty iff p[j - 1] is '*' and p[0..j - 3] matches empty
         for(int i = 1; i <= n; i++) dp[0][i] = i > 1 && p.charAt(i - 1) == '*' && dp[0][i - 2];
         
         for(int i = 1; i <= m; i++) {
             for(int j = 1; j<= n; j++) {
                 if(p.charAt(j - 1) != '*') {
                     dp[i][j] = dp[i - 1][j - 1] && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.');
                 }
                 else {
                     dp[i][j] = dp[i][j - 2] || (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j];
                 }
             }
         }
         return dp[m][n];
    }
}