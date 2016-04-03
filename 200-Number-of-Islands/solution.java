public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    res++;
                    merge(grid, i, j);
                }
            }
        }
        return res;
    }
    public void merge(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        merge(grid, i - 1, j);
        merge(grid, i, j - 1);
        merge(grid, i + 1, j);
        merge(grid, i, j + 1);
    }
}