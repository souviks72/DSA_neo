//https://leetcode.com/problems/rotting-oranges/submissions/901976283/
//https://www.youtube.com/watch?v=yf3oUhkvqA0&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=10
class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int freshCount = 0;
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    visited[i][j] = true;
                    Pair p = new Pair(i,j,0);
                    q.add(p);
                }else if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }

        int time=0,count=0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int delrow[] = {-1,1,0,0};
            int delcol[] = {0,0,-1,1};
            for(int i=0;i<4;i++){
                int nrow = p.x + delrow[i];
                int ncol = p.y + delcol[i];
                time = Math.max(time,p.t);
                if(nrow>=0 && nrow<rows && ncol>=0 && ncol<cols && !visited[nrow][ncol] && grid[nrow][ncol]==1){
                    visited[nrow][ncol] = true;
                    q.add(new Pair(nrow,ncol,p.t+1));
                    count++;
                }
            }
        }

        if(count!=freshCount) return -1;
        return time;
    }
}

class Pair{
    int x,y,t;
    Pair(int x, int y, int t){
        this.x = x;
        this.y = y;
        this.t = t;
    }
}