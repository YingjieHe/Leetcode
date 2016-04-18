public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        obstacleGrid[0][0] ^= 1;
        for(int i = 1; i < m; i++) 
            obstacleGrid[i][0] = obstacleGrid[i][0] == 1? 0 : obstacleGrid[i - 1][0];
        for(int i = 1; i < n; i++) 
            obstacleGrid[0][i] = obstacleGrid[0][i] == 1? 0 : obstacleGrid[0][i - 1];
        for(int i = 1; i < m; i++) 
            for(int j = 1; j < n; j++)
                obstacleGrid[i][j] = obstacleGrid[i][j] == 1? 0 : obstacleGrid[i][j - 1] + obstacleGrid[i - 1][j];
        return obstacleGrid[m - 1][n - 1];
    }
}