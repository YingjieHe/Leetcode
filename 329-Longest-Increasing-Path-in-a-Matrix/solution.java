public class Solution {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, dp, i, j));
            }
        }
        return max;
    }
    
    private int dfs(int[][] matrix, int[][] dp, int i, int j) {
        if(dp[i][j] != 0) return dp[i][j];
        int max = 1;
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] >= matrix[i][j]) continue;
            max = Math.max(max, dfs(matrix, dp, x, y) + 1);
        }
        dp[i][j] = max;
        return max;
    }
}