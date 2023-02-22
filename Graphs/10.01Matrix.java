//https://leetcode.com/problems/01-matrix/submissions/902670997/
//https://www.youtube.com/watch?v=edXdVwkYHF8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=13
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        boolean[][] visited = new boolean[rows][cols];
        int[][] dist = new int[rows][cols];
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                visited[i][j] = false;
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        int[] delrow = {-1,1,0,0};
        int[] delcol = {0,0,-1,1};

        while(!q.isEmpty()){
            Pair p = q.remove();
            dist[p.x][p.y] = p.step;

            for(int i=0;i<4;i++){
                int nrow = p.x + delrow[i];
                int ncol = p.y + delcol[i];
                if(nrow>=0 && nrow<rows && ncol>=0 && ncol<cols && !visited[nrow][ncol]){
                    visited[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol, p.step+1));
                }
            }
        }

        return dist;
    }
}

class Pair {
    int x,y,step;
    Pair(int x, int y, int data){
        this.x = x;
        this.y = y;
        this.step = data;
    }
}