public class NumMatrix{
    private int[][] colSums;
    private int[][] matrix;
    public NumMatrix(int[][] matrix){
     if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
         return;
     }  
     this.matrix = matrix;
     int m = matrix.length;
     int n = matrix[0].length;
     colSums = new int[n][m + 1];
     for (int i = 0; i < n; i++){
         for (int j = 1; j <= m; j++){
             colSums[i][j] = colSums[i][j - 1] + matrix[j - 1][i];
     }
    }
}
     public void update(int row, int col, int val){
       for (int i = row + 1; i < colSums[0].length; i++){
           colSums[col][i] += val - matrix[row][col];
       }  
       matrix[row][col] = val;
     }
     
     public int sumRegion(int row1, int col1, int row2, int col2){
      int ret = 0;
      for (int i = col1; i <= col2; i++){
       ret += colSums[i][row2 + 1] - colSums[i][row1];
      }
      return ret;
     }
}
     
     
     
// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);


