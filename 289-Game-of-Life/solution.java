public class Solution {
    int[][] dirs = {{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int live = 0;
                for(int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && (board[x][y] & 1) == 1) live++;
                }
                if(board[i][j] == 1 && (live == 2 || live == 3)) board[i][j] = 3;
                if(board[i][j] == 0 && live == 3) board[i][j] = 2;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}