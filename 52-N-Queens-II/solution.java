public class Solution {
    public int totalNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if(n <= 0) return 0;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, res, 0);
        return res.size();
    }
    
    private void dfs(char[][] board, List<List<String>> res, int col) {
        if(col == board.length) {
            List<String> list = new LinkedList<String>();
            for(int i = 0; i < board.length; i++) {
                list.add(String.valueOf(board[i]));
            }
            res.add(list);
            return;
        }
        for(int row = 0; row < board.length; row++) {
            if(valid(board, row, col)) {
                board[row][col] = 'Q';
                dfs(board, res, col + 1);
                board[row][col] = '.';
            }
        }
    }
    
    private boolean valid(char[][] board, int i, int j) {
        for(int x = 0; x < board.length; x++) {
            for(int y = 0; y < j; y++) {
                if(board[x][y] == 'Q' && (x + j == y + i || x + y == i + j || x == i)) return false;
            }
        }
        return true;
    }
}