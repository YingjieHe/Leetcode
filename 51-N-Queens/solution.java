public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n <= 0) return res;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, res, 0);
        return res;
    }
    
    private void dfs(char[][] board, List<List<String>> res, int col) {
        if(col == board.length) {
            List<String> list = new ArrayList<>();
            for(char[] c : board) {
                list.add(String.valueOf(c));
            }
            res.add(list);
            return;
        }
        for(int i = 0; i < board[0].length; i++) {
            if(valid(board, i, col)) {
                board[i][col] = 'Q';
                dfs(board, res, col + 1);
                board[i][col] = '.';
            }
        }
    }
    
    private boolean valid(char[][] board, int i, int j) {
        for(int x = 0; x < board.length; x++) {
            for(int y = 0; y < j; y++) {
                if(board[x][y] == 'Q' && (x == i || x + j == y + i || x + y == i + j)) return false;
            }
        }
        return true;
    }
}