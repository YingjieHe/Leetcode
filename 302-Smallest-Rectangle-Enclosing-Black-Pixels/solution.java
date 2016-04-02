public class Solution {
    int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE, maxX = 0, maxY = 0;
    public int minArea(char[][] image, int x, int y){
        if (image == null || image.length == 0 || image[0].length == 0) return 0;
        dfs(image, x, y);
        return (maxX - minX + 1) * (maxY - minY + 1);
        }

    public void dfs(char[][] image, int x, int y){
        int m = image.length, n = image[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n || image[x][y] == '0') return;
        image[x][y] = '0';
        minX = Math.min(minX, x);
        minY = Math.min(minY, y);
        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);
        dfs(image, x + 1, y);
        dfs(image, x - 1, y);
        dfs(image, x, y + 1);
        dfs(image, x, y - 1);
    }
}
    
 
