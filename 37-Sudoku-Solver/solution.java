public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isvalid(board, i, j, c)){
                            board[i][j] = c;
                            if(solve(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isvalid(char[][] board, int i, int j, char c){
        for(int m = 0; m < board.length; m++){
            if(board[m][j] == c) return false;
        }
        for(int m = 0; m < board[0].length; m++){
            if(board[i][m] == c) return false;
        }
        for(int m = i / 3 * 3; m < i / 3 * 3 + 3; m++){
            for(int n = j / 3 * 3; n < j / 3 * 3 + 3; n++){
                 if(board[m][n] == c) return false;
            }
        }
        return true;
    }
}