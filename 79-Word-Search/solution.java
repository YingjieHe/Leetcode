public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, i, j ,0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int len) {
        if(len == word.length()) return true;
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || word.charAt(len) != board[i][j]) return false;
        board[i][j] = '*';
        boolean res = dfs(board, word, i - 1, j ,len + 1) || dfs(board, word, i + 1, j ,len + 1) || dfs(board, word, i, j + 1 ,len + 1) || dfs(board, word, i, j - 1 ,len + 1);
        board[i][j] = word.charAt(len);
        return res;
    }
}