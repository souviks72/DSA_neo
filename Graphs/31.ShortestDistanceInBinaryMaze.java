//https://practice.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-a-binary-maze
//https://www.youtube.com/watch?v=U5Mw4eyUmw4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=36
class Solution {
    int shortestPath(int[][] grid, int[] src, int[] dst) {
        if(src[0]==dst[0] && src[1]==dst[1]) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        int dist[][] = new int[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dist[i][j] = (int)(1e9);
            }
        }
        
        Queue<Pair> q = new LinkedList<>();
        dist[src[0]][src[1]] = 0;
        q.add(new Pair(src[0],src[1],0));
        
        int delrow[] = {-1,1,0,0};
        int delcol[] = {0,0,1,-1};
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            
            for(int i=0;i<4;i++){
                int x = p.x + delrow[i];
                int y = p.y + delcol[i];
                
                if(x>=0 && x<rows && y>=0 && y<cols && grid[x][y]==1 && p.d+1<dist[x][y]){
                    if(x==dst[0] &&y==dst[1]) return p.d+1;
                    dist[x][y] = p.d+1;
                    q.add(new Pair(x,y,p.d+1));
                }
            }
        }
        return -1;
    }
}

class Pair{
    int x,y,d;
    Pair(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}