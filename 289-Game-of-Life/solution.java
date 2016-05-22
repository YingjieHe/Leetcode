public class Solution {
    int[][] dir ={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int n = board.length, m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int live = 0;
                for(int[] d : dir){
                    if(d[0] + i < 0 || d[0] + i >= n || d[1] + j < 0 || d[1] + j >= m) continue;
                    live += board[d[0] + i][d[1] + j] & 1;
                }
                if(board[i][j] == 1 && live >= 2 && live <= 3) board[i][j] = 3;
                if(board[i][j] == 0 && live == 3) board[i][j] = 2;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] >>= 1;
            }
        }
    }
}