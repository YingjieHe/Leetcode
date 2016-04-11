public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            Set<Character> row = new HashSet<Character>();
            Set<Character> col = new HashSet<Character>();
            Set<Character> cube = new HashSet<Character>();
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.' && !row.add(board[i][j])) return false;
                if(board[j][i] != '.' && !col.add(board[j][i])) return false;
                int r = i / 3 * 3;
                int c = i % 3 * 3;
                if(board[r + j / 3][c + j % 3] != '.' && !cube.add(board[r + j / 3][c + j % 3])) return false;
            }
        }
        return true;
    }
}