public class Solution {
    public int[][] generateMatrix(int n) {
        if(n < 0) return null;
        int[][] res = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        int count = 1;
        while(count <= n * n){
            int i = rowBegin, j = colBegin;
            for(j = colBegin; j <= colEnd; j++){
                res[rowBegin][j] = count++;
            }
            rowBegin++;
            for(i = rowBegin; i <= rowEnd; i++){
                res[i][colEnd] = count++;
            }
            colEnd--;
            for(j = colEnd; j >= colBegin; j--){
                res[rowEnd][j] = count++;
            }
            rowEnd--;
            for(i = rowEnd; i >= rowBegin; i--){
                res[i][colBegin] = count++;
            }
            colBegin++;
        }
        return res;
    }
}