public class Solution {

    int[][] dir ={{0,1},{0,-1},{1,0},{-1,0}};
    public void wallsAndGates(int[][] rooms) {
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0)
                    bfs(rooms,i,j);
            }
        }
    }
    public void bfs(int[][] rooms,int i,int j){
        for(int[] d:dir){
            if(i+d[0]>=0 && i+d[0]<rooms.length && j+d[1]>=0 && j+d[1]<rooms[0].length && rooms[i+d[0]][j+d[1]]>rooms[i][j]+1){
                rooms[i+d[0]][j+d[1]]=rooms[i][j]+1;
                bfs(rooms,i+d[0],j+d[1]);
            }
        }
    }

}