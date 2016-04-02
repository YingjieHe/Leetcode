public class Solution {
    
    public int shortestDistance(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return -1;
        }
        int cols = grid[0].length;
        if(cols == 0) return -1;
        
        int[][] sum = new int[rows][cols];
        int ones = 0;
        
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j)
                if(grid[i][j] == 1) {
                    bfs(grid, i, j, rows, cols, sum);
                    ones++;
                }
                
        }
        
        int shortest = Integer.MAX_VALUE;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j)
                if(grid[i][j] == -ones && sum[i][j] < shortest) shortest = sum[i][j];
        }
        
        if (shortest < Integer.MAX_VALUE){
           return shortest;
       }
       return -1;
    }
    
    public void bfs(int[][] grid, int x, int y, int rows, int cols, int[][] sum) {
        
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{x, y});
        q.add(null);
        
        Set<String> set = new HashSet<String>();
        int level = 1;
        
        while(!q.isEmpty()){
            int[] poll = q.poll();
            if(poll == null){
                level++;
                q.add(null);
                if(q.peek() == null) break;
                continue;
            }
            int px = poll[0];
            int py = poll[1];
            if(inBoundary(px, py-1, rows, cols) && grid[px][py-1] <= 0 && !set.contains(px + "." + (py-1))) {
                q.add(new int[]{px, py-1});
                sum[px][py-1] += level;
                set.add(px + "." + (py-1));
                grid[px][py-1]--;
            }
            
            if(inBoundary(px-1, py, rows, cols) && grid[px-1][py] <= 0 && !set.contains((px-1) + "." + py)) {
                q.add(new int[]{px-1, py});
                sum[px-1][py] += level;
                set.add((px-1) + "." + py);
                grid[px-1][py]--;
            }
            
            if(inBoundary(px, py+1, rows, cols) && grid[px][py+1] <= 0 && !set.contains(px + "." + (py+1))) {
                q.add(new int[]{px, py+1});
                sum[px][py+1] += level;
                set.add(px + "." + (py+1));
                grid[px][py+1]--;
            }
            
            if(inBoundary(px+1, py, rows, cols) && grid[px+1][py] <= 0 && !set.contains((px+1) + "." + py)) {
                q.add(new int[]{px+1, py});
                sum[px+1][py] += level;
                set.add((px+1) + "." + py);
                grid[px+1][py]--;
            }            
        }
    }
    
    public boolean inBoundary(int x, int y, int rows, int cols){
        if(x >=0 && x < rows && y >=0 && y < cols) return true;
        return false;
    }
}