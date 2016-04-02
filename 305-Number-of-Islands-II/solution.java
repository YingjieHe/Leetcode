public class Solution {
    
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
      
     List<Integer> res = new ArrayList<Integer>();
     int count = 0;
     int[] roots = new int[m * n];
     Arrays.fill(roots, -1); 
     for (int[] p: positions){
         int root = n * p[0] + p[1];
         roots[root] = root;
         count++;
         for(int[] dir: dirs){
             int x = p[0] + dir[0];
             int y = p[1] + dir[1];
             int idNb = n * x + y;
             if (x < 0 || y < 0 || x >= m || y >= n || roots[idNb] == -1) continue;
             int rootNb = findlsland(roots, idNb);
             if (root != rootNb){
                 roots[rootNb] = root;
                 count--;
             }
         }
         res.add(count);
     }
     return res;
    }
    public int findlsland(int[] root, int id){
        while (id != root[id]) id = root[id];
        return id;
    }
}