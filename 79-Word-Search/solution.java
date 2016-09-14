public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, String word, int len) {
        if(len == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(len) != board[i][j]) return false;
        board[i][j] = '*';
        boolean res = false;
        res = res || dfs(board, i - 1, j, word, len + 1);
        res = res || dfs(board, i + 1, j, word, len + 1);
        res = res || dfs(board, i, j - 1, word, len + 1);
        res = res || dfs(board, i, j + 1, word, len + 1);
        board[i][j] = word.charAt(len);
        return res;
    }
}